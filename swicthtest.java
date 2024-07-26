public class swicthtest {

    public static int dorrow(int bankerall, int playerthird) {
        int thd = 0;
        switch (playerthird){
            case 10:
                thd = 5;
                break;
            case 0:
            case 1:
                thd = 3;
                break;
            case 2:
            case 3:
                thd = 4;
                break;
            case 4:
            case 5:
                thd = 5;
                break;
            case 6:
            case 7:
                thd = 6;
                break;
            case 8:
                thd = 2;
                break;
            case 9:
                thd = 3;
                break;
        }
        if (bankerall <= thd){
            return 1;
        } else {
            return 0;
        }
    }

    public static int dorrow2(int bankerall, int playerthird) {
        final int H = 1;
        final int S = 0;
        final int[][] table = {
            //r:bankerall, h:playerthird
            { H, H, H, H, H, H, H, H, H, H, H },
            { H, H, H, H, H, H, H, H, H, H, H },
            { H, H, H, H, H, H, H, H, H, H, H },
            { H, H, H, H, H, H, H, H, H, S, H },
            { H, S, S, H, H, H, H, H, H, S, H },
            { H, S, S, S, S, H, H, H, H, S, S },
            { S, S, S, S, S, S, S, H, H, S, S },
            { S, S, S, S, S, S, S, S, S, S, S }
        };
        return (table[bankerall][playerthird]);
    }
    public static void main(String[] args) {
        int bankerall = 4;
        int playerthird = 8;

        int result = dorrow2(bankerall, playerthird);
        if (result == 1){
            System.out.println("Banker should draw");
        } else {
            System.out.println("Banker should not draw");
        }
        ;
    }
}
