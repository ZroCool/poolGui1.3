package poolsample;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class GuiPool extends JFrame {
    /*
     life time = 25sqf
     powder marble = 15sqf
     blue stone =15sqf
     concrete =25sqf
     cpu = 1000
     mineral=1500
     ccpu+mineral = 2500
    color lights = 1000
    
    
    
     */

    JRadioButton y, n, y1, n1, sCpu, sMin, sCpuMin, sNoCon;
    JPanel poolPanel, titlePool, titlePanel, test, test2, panel4, spaPanel, spaPanelSq, heaterPanel,
            materialFinish, lightsHeating, lightPanel, depthPanel, ElectricPanel, controllerPanel;
    JButton mybutton, produceQuote, sqF;
    JLabel mylabel, depth, spaSelection, electric, heaterSelection, gasLength,
            lightSelection, appNameL, dEnd, sEnd, mX, mX1, eQ, eQ1;
    JCheckBox lightUpgrade;
    public String[] heaterOptions = {"Nothing", "Gas", "HeatPump"};
    double[] Gas = {0, 80, 85, 90, 95};
    double[] depthOptions = {4, 6, 8, 10, 12};
    public String[] materialSelection = {"Material options",
        "Blue Stone", "Concrete"};
    public String[] finish = {"Finish Options    ",
        "lifeTime", "powderedMarble"};
    private double finishCost, cLights, cpuCost, materialCost,
             gasPerFt, electricPerFt, gasHeater, heatPump,
            spaSqf, poolSqf, totalSQF, sEndDepth, dEndDepth, aveDepth, gasInstalLngth,
            eFootInstall,totalElectricCost, poolFinalPrice,totalsqfCostD, totalGasCost;

    private String spaText = "";
    private String poolText = "";
    private String materialInstallText = "";
    private String finsihInstallText = "";
    private String electricInstallText = "";
    private String gasInstallText = "";
    private String cpuText = "";

    public static int WIDTH, HEIGHT, sample;

    private boolean runTime;

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
        
    }
    
    public GuiPool() {
        runTime = false;
        getContentPane().setBackground(Color.yellow);
        finishCost = 0;
        cLights = 0;
        materialCost = 0;
        cpuCost = 0;

        gasPerFt = 35;
        electricPerFt = 25;
        gasHeater = 1500;
        heatPump = 2500;

        setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));

        poolPanel = new JPanel();
        poolPanel.setBackground(Color.yellow);
        ElectricPanel = new JPanel();
        ElectricPanel.setBackground(Color.yellow);
        depthPanel = new JPanel();
        depthPanel.setBackground(Color.yellow);
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.yellow);
        titlePool = new JPanel();
        titlePool.setBackground(Color.yellow);
        materialFinish = new JPanel();
        materialFinish.setBackground(Color.yellow);
        lightsHeating = new JPanel();
        lightsHeating.setBackground(Color.yellow);
        test = new JPanel();
        test.setBackground(Color.yellow);
        test2 = new JPanel();
        test2.setBackground(Color.yellow);
        panel4 = new JPanel();
        panel4.setBackground(Color.yellow);
        spaPanel = new JPanel();
        spaPanel.setBackground(Color.yellow);
        spaPanelSq = new JPanel();
        spaPanelSq.setBackground(Color.yellow);
        heaterPanel = new JPanel();
        heaterPanel.setBackground(Color.yellow);
        lightPanel = new JPanel();
        lightPanel.setBackground(Color.yellow);
        controllerPanel = new JPanel();
        controllerPanel.setBackground(Color.yellow);
        mybutton = new JButton("Calculate results");
        produceQuote = new JButton("Produce Quote");
        sqF = new JButton("submit pool dimension");
        

        ButtonGroup spaChoice = new ButtonGroup();
        ButtonGroup spaController = new ButtonGroup();
        ButtonGroup electricChoice = new ButtonGroup();
        JTextField s1 = new JTextField(8), s2 = new JTextField(8),
                shallow = new JTextField(12), appName = new JTextField(20),
                deep = new JTextField(12), t2 = new JTextField(30),
                sqFootage = new JTextField(15), spaSqFootage = new JTextField(8),
                t3 = new JTextField(30), spaLength = new JTextField(7),
                spaWidth = new JTextField(7), t4 = new JTextField(20);
        JTextField result = new JTextField(15);

        lightUpgrade = new JCheckBox("upgrade to collored lights");
        lightUpgrade.setSelected(false);

        deep.setEditable(false);
        shallow.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);

        sqFootage.setEditable(false);
        JComboBox deepEndDD = new JComboBox();
        JComboBox materialDropDown = new JComboBox();
        JComboBox finishDropDown = new JComboBox();
        JComboBox heaterDropDown = new JComboBox();
        JComboBox gasLengthDropDown = new JComboBox();
        JComboBox shallowEnd = new JComboBox();
        JComboBox electricFootage = new JComboBox();

        mylabel = new JLabel("square footage");
        depth = new JLabel("pool depth");
        dEnd = new JLabel("Deep End   ");
        sEnd = new JLabel("Shallow End");
        spaSelection = new JLabel("Add Spa");
        electric = new JLabel("Add Electric");
        heaterSelection = new JLabel("select a heating option");
        gasLength = new JLabel("select gas length");
        lightSelection = new JLabel("select light options");
        appNameL = new JLabel("enter the cusomers name");
        mX = new JLabel("X");
        mX1 = new JLabel("X");
        eQ = new JLabel("=");
        eQ1 = new JLabel("=");

        add(titlePool);
        add(depthPanel);
        add(spaPanel);
        add(materialFinish);
        add(lightsHeating);
        add(produceQuote);
        
        

        titlePool.setLayout(new BoxLayout(titlePool, BoxLayout.Y_AXIS));
        titlePool.add(titlePanel);
        titlePool.add(poolPanel);

        titlePanel.add(appNameL);
        titlePanel.add(appName);

        materialFinish.setLayout(new BoxLayout(materialFinish, BoxLayout.Y_AXIS));
        materialFinish.add(spaPanel);
        materialFinish.add(spaPanelSq);
        materialFinish.add(sqF);
        materialFinish.add(test);
        materialFinish.add(panel4);
        materialFinish.add(controllerPanel);

        lightsHeating.setLayout(new BoxLayout(lightsHeating, BoxLayout.Y_AXIS));
        lightsHeating.add(lightPanel);
        lightsHeating.add(heaterPanel);

        poolPanel.add(mylabel);
        poolPanel.add(s1);
        poolPanel.add(mX);
        poolPanel.add(s2);
        poolPanel.add(eQ);
        poolPanel.add(sqFootage);

        depthPanel.add(dEnd);
        depthPanel.add(deepEndDD);
        depthPanel.add(deep);
        depthPanel.add(sEnd);
        depthPanel.add(shallowEnd);
        depthPanel.add(shallow);

        test.add(materialDropDown);
        test.add(t2);

        panel4.add(finishDropDown);
        panel4.add(t3);

        lightPanel.add(electric);
        lightPanel.add(ElectricPanel);

        test2.add(t4);
        test2.add(mybutton);
        test2.add(result);

        y = new JRadioButton("YES", false);
        y.setActionCommand(y.getText());
        n = new JRadioButton("NO", true);
        y1 = new JRadioButton("YES", false);
        n1 = new JRadioButton("NO", true);

        spaPanel.add(lightUpgrade);
        spaPanel.add(spaSelection);
        spaChoice.add(y);
        spaChoice.add(n);
        spaPanel.add(y);
        spaPanel.add(n);
        spaPanelSq.setVisible(false);
        spaPanelSq.add(spaLength);
        spaPanelSq.add(mX1);
        spaPanelSq.add(spaWidth);
        spaPanelSq.add(eQ1);
        spaSqFootage.setEditable(false);
        spaPanelSq.add(spaSqFootage);

        sNoCon = new JRadioButton("No Controller", true);
        sCpu = new JRadioButton("CPU", false);
        sMin = new JRadioButton("Mineral", false);
        sCpuMin = new JRadioButton("CPU + Mineral", false);

        spaController.add(sNoCon);
        spaController.add(sCpu);
        spaController.add(sMin);
        spaController.add(sCpuMin);
        controllerPanel.add(sNoCon);
        controllerPanel.add(sCpu);
        controllerPanel.add(sMin);
        controllerPanel.add(sCpuMin);

        electricChoice.add(y1);
        electricChoice.add(n1);
        ElectricPanel.add(y1);
        ElectricPanel.add(n1);
        ElectricPanel.add(electricFootage);
        electricFootage.setVisible(false);

        heaterPanel.add(heaterSelection);
        gasLengthDropDown.setVisible(false);
        gasLength.setVisible(false);
        heaterPanel.add(heaterDropDown);
        heaterPanel.add(gasLength);
        heaterPanel.add(gasLengthDropDown);

        for (int i = 0; i < Gas.length; i++) {
            electricFootage.addItem(Gas[i]);
        }
        electricFootage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        for (int i = 0; i < depthOptions.length; i++) {
            deepEndDD.addItem(depthOptions[i]);
        }
        deepEndDD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deep.setText("deep end = : "
                        + deepEndDD.getSelectedItem());

            }
        });
        for (int i = 0; i < depthOptions.length; i++) {
            shallowEnd.addItem(depthOptions[i]);
        }
        shallowEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shallow.setText("shallow end = : "
                        + shallowEnd.getSelectedItem());

            }
        });
        for (int i = 0; i < materialSelection.length; i++) {
            materialDropDown.addItem(materialSelection[i]);
        }
        materialDropDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t2.setText("You Selected : "
                        + materialDropDown.getSelectedItem());
            }
        });

        for (int i = 0; i < finish.length; i++) {
            finishDropDown.addItem(finish[i]);

        }
        finishDropDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t3.setText("You Selected : "
                        + finishDropDown.getSelectedItem());
            }
        });

        for (int i = 0; i < heaterOptions.length; i++) {
            heaterDropDown.addItem(heaterOptions[i]);
        }
        heaterDropDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (heaterDropDown.getSelectedItem().equals("Gas")) {
                    gasLengthDropDown.setVisible(true);
                    gasLength.setVisible(true);
                } else {
                    gasLengthDropDown.setVisible(false);
                    gasLength.setVisible(false);
                };

            }
        });
        for (int i = 0; i < Gas.length; i++) {
            gasLengthDropDown.addItem(Gas[i]);
        }

        gasLengthDropDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gasInstalLngth = (double) gasLengthDropDown.getSelectedItem();
                if (gasInstalLngth == 0) {
                    gasInstallText = "you havew chose to use "
                            + "your onw guys for instalations ";
                } else {
                    gasInstallText = "we will be insalling" + gasInstalLngth
                            + "feet of gas piping";
                    totalGasCost=gasInstalLngth*gasPerFt;
                }
            }
        });

        setTitle("calculate estimated cost");
        setSize(600, 450);
        
        setResizable(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        y.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                spaPanelSq.setVisible(true);
                //System.out.println("you have selected to add the spa");
            }
        });
        n.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                spaPanelSq.setVisible(false);
            }
        });
        y1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                electricFootage.setVisible(true);
            }
        });
        n1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                electricFootage.setVisible(false);
            }
        });

        sqF.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {

                repaint();
                if (isNumeric(s2.getText()) == true && isNumeric(s1.getText()) == true) {

                    double sqf = Double.parseDouble(s1.getText())
                            * Double.parseDouble(s2.getText());
                    sqFootage.setText(String.valueOf(sqf));
                } else {
                    sqFootage.setText("ENTER VALID NUMBERS!");
                };

                if (isNumeric(spaWidth.getText()) == true && isNumeric(spaLength.getText()) == true) {

                    double sqf = Double.parseDouble(spaLength.getText())
                            * Double.parseDouble(spaWidth.getText());
                    spaSqFootage.setText(String.valueOf(sqf));
                } else {
                    spaSqFootage.setText("ENTER VALID NUMBERS!");
                };

            }
        });
        produceQuote.addActionListener(new ActionListener() {
            ///////////// THE ACTION OF PULLING ALL DATA AND PROCUCE QUOTE.
            public void actionPerformed(ActionEvent event) {

                if (appName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "must enter name");
                } else if (isNumeric(s2.getText()) == false
                        || isNumeric(s1.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "enter valid pool dimensions");
                } else if ((isNumeric(spaWidth.getText()) == false
                        || isNumeric(spaLength.getText()) == false) && y.isSelected() == true) {
                    JOptionPane.showMessageDialog(null, "enter valid spa dimensions");
                } else if (t2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "enter valid material");
                } else if (t3.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "enter valid finish");
                } else {
                    runTime = true;
                }

                if (runTime == true) {
                    String quoteTitle = appName.getText();

                    //////Square footage from  pool
                    if (isNumeric(s2.getText()) == true && isNumeric(s1.getText()) == true) {

                        poolSqf = Double.parseDouble(s1.getText())
                                * Double.parseDouble(s2.getText());
                        sqFootage.setText(String.valueOf(poolSqf));
                    } else {
                        sqFootage.setText("ENTER VALID NUMBERS!");
                    };
                    /////////////Square footage from spa

                    if (y.isSelected()) {// WRITE HERE TEXT FOR SPA
                        spaText = "this is the desciption hard coded for the spa"
                                + "/n blah blah blah wonderfull spa";
                        if (isNumeric(spaWidth.getText()) == true && isNumeric(spaLength.getText()) == true) {

                            spaSqf = Double.parseDouble(spaLength.getText())
                                    * Double.parseDouble(spaWidth.getText());
                            spaSqFootage.setText(String.valueOf(spaSqf));

                        } else {
                            spaSqFootage.setText("ENTER VALID NUMBERS!");
                        };
                    } else {
                        spaText = "";
                        System.out.println("spa not selected");
                        spaSqf = 0;
                    }

                   
                    System.out.println(totalSQF + "xxxxxx");
                    //////case statement for material"Blue Stone", "Concrete"};
                    String material = (String) materialDropDown.getSelectedItem();

                    switch (material) {
                        case "Blue Stone":
                            System.out.println("Blue Stone");
                            materialInstallText = "this is the text for stone";
                            materialCost = 15;
                            break;
                        case "Concrete":
                            materialInstallText = "this is the text for concrete";
                            materialCost = 25;
                            System.out.println("Concrete");
                            break;
                    }
                    ///////////case statement for finsih type"blah1", "Blah2", "blah3"};
                    String finish = (String) finishDropDown.getSelectedItem();
                    switch (finish) {
                        case "lifeTime":
                            System.out.println("lifeTime");
                            finsihInstallText = "this is for lifetime finsih "
                                    + "soo wonderfull it shines";
                            finishCost = 25;
                            break;
                        case "powderedMarble":
                            finsihInstallText = "MARBLE MARBLE MARBLE";
                            System.out.println("powderedMarble");
                            finishCost = 15;
                            break;

                    }
                    ////////// case state for heater options{"Nothing", "Gas", "HeatPump"};
                    String heater = (String) heaterDropDown.getSelectedItem();
                    switch (heater) {
                        case "Nothing":
                            System.out.println("Nothing");
                            break;
                        case "Gas":
                            //if(){};
                            System.out.println("Gas");
                            break;
                        case "HeatPump":
                            System.out.println("HeatPump");
                            break;
                    }//{4,6,8,10,12}
                    sEndDepth = (double) shallowEnd.getSelectedItem();
                    dEndDepth = (double) deepEndDD.getSelectedItem();
                    aveDepth = (dEndDepth + sEndDepth) / 2;

                    if (y1.isSelected() == true) {
                        eFootInstall = (double) electricFootage.getSelectedItem();

                        if (eFootInstall == 0) {
                            electricInstallText
                                    = "you have selected top have the ectric"
                                    + " work install BY YOUR OWN GUYS";
                        } else {
                            electricInstallText
                                    = "you have selected top have the ectric"
                                    + " work install all island" + eFootInstall + "feet";
                             totalElectricCost = eFootInstall*electricPerFt;
                        };

                    };

                    ///////////// identify controller slection sNoCon sCpu sMin sCpuMin
                    if (y.isSelected() && sNoCon.isSelected()) {
                        JOptionPane.showMessageDialog(null, "must select controller for spa ");
                    } else {
                        if (sNoCon.isSelected()) {
                            System.out.println("no controller");
                        } else if (sCpu.isSelected()) {
                            System.out.println("cpu controller");
                            cpuText = "CPU-CPU-CPU";
                            cpuCost = 1000;

                        } else if (sMin.isSelected()) {
                            System.out.println("mineral controller");
                            cpuText = "MINERAL-MINERAL-MINERAL";
                            cpuCost = 1500;

                        } else if (sCpuMin.isSelected()) {
                            System.out.println("cpu+mineral controller");
                            cpuText = "CM-CM-CM-CM";
                            cpuCost = 2500;
                        }
                        ;
                    }
                    //////// selected to upgrade to color lights
                    if (lightUpgrade.isSelected()) {
                        System.out.println("color lights selected");
                        cLights= 1000;
                    };
                    if (y1.isSelected()) {
                        System.out.println("adding electric");
                        electricFootage.getSelectedItem();
                        System.out.println("wireing distance"
                                + electricFootage.getSelectedItem());
                        double totalElectricCost = 
                                (double) electricFootage.getSelectedItem();

                    };
                    // cost analasys!! poolSqf  spaSqf  finishCost cLights cpuCost
                    //materialCost cLights totalElectricCost
                    
                    double totalsqfCost =finishCost+ materialCost;
                     totalSQF = (poolSqf + spaSqf)*aveDepth;
                     totalsqfCostD = totalSQF * totalsqfCost;
                    
                    poolFinalPrice=totalsqfCostD+totalElectricCost+cLights+
                            cpuCost+totalGasCost;
                    
                    System.out.println(poolFinalPrice+"toal sqf!!");
                    
                    
                    String text = "Hello world";
                    try {
                        File file = new File(quoteTitle + ".txt");
                        BufferedWriter output = new BufferedWriter(new FileWriter(file));
                        output.write( " this is what gets written");
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    boolean spaSelected = y.isSelected();

                    if (spaSelected) {
                        System.out.println("you have selected to add the spa");
                    } else {
                    }

                    System.out.println("made it the the end of logic"
                            //+ spaText
                            //+ materialConcreteText + materialStoneText + "__--__"
                            // + finsihLifeTimeText
                            // + finsihPMarbleTimeText + "==>"+cpuText
                            //  + "****"+aveDepth
                            //  +gasInstallText
                            + electricInstallText + "<--"
                    );

                }
            }

        });

    }
}
