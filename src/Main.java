
public class Main {
    public static void main(String[] args) {

        Watcher bigBrother = new Watcher();
        int health = 0;
        while(true){
            try{
                int h = bigBrother.getHealth();
                if(h < health) {
                    System.out.println("Damage taken");
                    if(h == 0)
                        System.out.println("Dead");
                }
                health = h;
            }catch (NoHeartsException nhe){}
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}