public class Solution {
    private int compute(int x, int y, int opr){
        switch(opr){
            case 1:
                return x + y;
            case 2:
                return x - y;
            case 3:
                return x * y;
            case 4:
                return (y == 0) ? -1 : (x / y);
        }
        return -1;
    }
    
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        int[] val = new int[len];
        int[] opr = new int[len];
        boolean[] dealt = new boolean[len];
        int elementsToDeal = len;
        
        for(int i = 0; i < len; i++){
            val[i] = -1;
            opr[i] = 0;
            dealt[i] = false;
        }
        
        for(int i = 0; i < len; i++){
            try{
                val[i] = Integer.parseInt(tokens[i]);
            } catch(NumberFormatException e){
                val[i] = -1;
                if(tokens[i].equals("+")){
                    opr[i] = 1;
                } else if(tokens[i].equals("-")){
                    opr[i] = 2;
                } else if(tokens[i].equals("*")){
                    opr[i] = 3;
                } else if(tokens[i].equals("/")){
                    opr[i] = 4;
                } else{
                    opr[i] = -1;
                    dealt[i] = true;
                }
                elementsToDeal--;
            }
        }
        
        while(true){
            int x = 0, y = 0;
            boolean xRecorded = false;
            boolean yRecorded = false;
            boolean toBreak = false;
            for(int i = 0; i < len; i++){
                if(dealt[i]) continue;
                if(opr[i] == 0){
                    if(!xRecorded){
                        x = i;
                        xRecorded = true;
                        if(elementsToDeal == 1) return val[x];
                    }
                    else if(!yRecorded){
                        y = i;
                        yRecorded = true;
                    }
                    else{
                        x = y;
                        y = i;
                    }
                }
                else if(opr[i] > 0){
                    if(xRecorded && yRecorded){
                        val[y] = compute(val[x], val[y], opr[i]);
                        dealt[x] = true;
                        dealt[i] = true;
                        elementsToDeal--;
                        if(elementsToDeal == 1) return val[y];
                        if(elementsToDeal < 1) return 0;
                        toBreak = true;
                    }
                    xRecorded = false;
                    yRecorded = false;
                }
                if(toBreak) break;
            }
        }
    }
}