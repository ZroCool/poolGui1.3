package poolsample;


import javax.swing.JFrame;
import javax.swing.JOptionPane;


class PoolSample  {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        
        String pW = "allisland";

        /*String s = (String) JOptionPane.showInputDialog(
                "enter password 5 failed atempts will exit aplication");

        int result = pW.compareToIgnoreCase(s);
        int j = 1;
        while (result != 0) {

            j++;
            s = JOptionPane.showInputDialog(
                    "enter password 5 failed atempts will exit aplication");
            if (j >= 5) {
                System.exit(1);
            }

            result = pW.compareToIgnoreCase(s);

        }

        System.out.println(result);*/

        GuiPool trial = new GuiPool();
        trial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
