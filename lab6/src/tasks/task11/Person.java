package tasks.task11;

public class Person extends Thread {
    public long num = 0;
    public boolean washing = false;
    public String name;
    public boolean isWoman;

    public Person(String name, boolean isWoman) {
        this.isWoman = isWoman;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            rest();
            ShowerRoom.wantsToEnter(this);
            if(!this.washing) System.err.println("!!!!!!!!!!!!!!!!!!!!!!!");
            wash();
            ShowerRoom.leaves(this);
        }
    }

    public void wash() {
        for(long i = 1; i < 1_000_000; i++) {
            var k = i*i;
            for(long j = k; j > 0; j /= 10)
                this.num = this.num*10 + (j%10);
        }
    }
    public void rest() {
        for(long i = 1; i < 10_000_000; i++) {
            var k = i*i;
            for(long j = k; j > 0; j /= 10)
                this.num = this.num*10 + (j%10);
        }
    }

}
