import java.util.Scanner;

public interface GameStatus {
    public boolean start();
    public boolean end();
    public boolean isRepeat();
    public int getGameRuleLength();
    public Scanner getScanner();

}
