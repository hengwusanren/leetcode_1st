class Solution {
public:
    //return the comparison of x and y
    int intcmp(int x, int y) {
    	if(x > y)  return 1;
    	if(x == y) return 0;
    	return -1;
    }
    
    //return the position of the next turn, signed with +/- (a high/low turn)
    int getNextTurn(int height[], int begin, int thisTurn, int len) {
    	if(begin >= len - 1) return 0;
    	int i = begin + 1;
    	while(i < len - 1 && intcmp(height[i + 1], height[i]) != thisTurn)
    		i++;
    	
    	return -thisTurn * i;
    }
    
    int candyComputer(vector<int> &ratings) {
        const int len = ratings.size();
        if(len < 2) return len;
        if(len == 2) {
        	if(ratings.at(0) == ratings.at(1)) 
        		return 2;
        	else return 3;
        }

        //to get height
        int* height = new int[len];
        height[0] = 0;
        for(int i = 1; i < len; i++)
        	height[i] = height[i - 1] + intcmp(ratings.at(i), ratings.at(i - 1));
        
        int* turn = new int[len];
        for(int i = 0; i < len; i++) turn[i] = 0;

        //to get turn[0]
        if(height[1] > height[0])
        	turn[0] = -1;
        else if(height[1] < height[0])
        	turn[0] = 1;
        else {
        	int i = 1;
        	while(i < len && height[i] == height[0])
        		i++;
        	if(i == len)
        		turn[0] = -1;
        	else
        		turn[0] = intcmp(height[0], height[i]);
        }
        
        //to get turn
        int begin = 0;
        int thisTurn = turn[0];
        //int next = 1;
        while(begin < len - 1) {
        	int next = getNextTurn(height, begin, thisTurn, len);
        	thisTurn = next > 0 ? 1 : -1;
        	next *= thisTurn;
        	turn[next] = thisTurn;
        	begin = next;
        }

        //to get new height
        int* newHeight = new int[len];
        for(int i = 0; i < len; i++) newHeight[i] = 0;
        for(int i = 0; i < len; i++) {
        	if(turn[i] == -1) {
        		newHeight[i] = 1;
        		int j = i - 1, k = i + 1;
        		while(j >= 0) {
        			if(turn[j] == 1) {
        				int newH = height[j] + 1 - height[i];
        				newHeight[j] = newHeight[j] > newH ? newHeight[j] : newH;
        				break;
        			}
        			newHeight[j] = height[j] + 1 - height[i];
        			j--;
        		}
        		while(k < len) {
        			if(turn[k] == 1) {
        				int newH = height[k] + 1 - height[i];
        				newHeight[k] = newHeight[k] > newH ? newHeight[k] : newH;
        				break;
        			}
        			newHeight[k] = height[k] + 1 - height[i];
        			k++;
        		}
        	}
        }
        if(newHeight[0] <= newHeight[1]) newHeight[0] = 1;
        if(newHeight[len - 1] <= newHeight[len - 2]) newHeight[len - 1] = 1;

        //sum
        int sum = 0;
        for(int i = 0; i < len; i++)
        	sum += newHeight[i];
        	
        delete [] height;
        delete [] turn;
        delete [] newHeight;
        
        return sum;
    }
    
    //the method to call
    int candy(vector<int> &ratings) {
        if(ratings.empty()) return 0;
        int len = ratings.size();
        
        int sum = 0;
        vector<int> temp;
        
        temp.push_back(ratings.at(0));
        for(int i = 1; i < len; i++) {
            if(ratings.at(i) != ratings.at(i - 1))
                temp.push_back(ratings.at(i));
            else {
                sum += candyComputer(temp);
                temp.clear();
                temp.push_back(ratings.at(i));
            }
        }
        sum += candyComputer(temp);
        
        vector<int>().swap(temp);
        
        return sum;
    }
};