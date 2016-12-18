/**
 * created by stickmy on 2016/12/18 18:21
 */
public class StateMachine {
    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public StateMachine(int count) {
        this.count = count;
        if(count > 0) {
            state = NO_QUARTER;
        }
    }

    public void insertQuarter() {
        if(state == HAS_QUARTER) {
            System.out.println("已经投过硬币");
        } else if(state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("投币成功");
        } else if(state == SOLD_OUT) {
            System.out.println("票卖完了");
        } else if(state == SOLD) {
            System.out.println("请稍等，正在出票");
        }
    }

    public void ejectQuarter() {
        if(state == HAS_QUARTER) {
            System.out.println("退款成功");
            state = NO_QUARTER;
        } else if(state == NO_QUARTER) {
            System.out.println("你还没投币");
        } else if(state == SOLD) {
            System.out.println("对不起，您已经转动曲柄了");
        } else if(state == SOLD_OUT) {
            System.out.println("你还没投币");
        }
    }

    public void turnCrank() {
        if(state == SOLD) {
            System.out.println("你已经取过票了");
        } else if (state == NO_QUARTER) {
            System.out.println("需要先投币");
        } else if (state == SOLD_OUT) {
            System.out.println("已经没有票了");
        } else if(state == HAS_QUARTER) {
            System.out.println("稍等...");
            state = SOLD;
            dispense();
        }
    }

    public void dispense() {
        if (state == SOLD) {
            System.out.println("正在出票");
            count -= 1;
            if(count == 0) {
                System.out.println("没票了，处理中...");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if(state == NO_QUARTER) {
            System.out.println("你需要先投币");
        } else if(state == SOLD_OUT) {
            System.out.println("没有票了");
        } else if(state == HAS_QUARTER) {
            System.out.println("没有票了");
        }
    }
}
