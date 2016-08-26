package com.nepxion.demo.swing.scheduler;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.statusbar.JStatusBar;
import com.nepxion.swing.statusbar.JStatusItem;
import com.nepxion.swing.textfield.number.JNumberTextField;

public class DemoSchedulerPanel
    extends JPanel
{
    public DemoSchedulerPanel()
    {
        double[][] size =
            {
            {TableLayout.FILL},
            {0.4, 0.4}
        };
        TableLayout tableLayout = new TableLayout(size);
        JPanel panel = new JPanel();
        panel.setLayout(tableLayout);
        panel.add(new SchedulerPanel(1), "0, 0, 0, 0");
        panel.add(new SchedulerPanel(2), "0, 1, 0, 1");

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" 多线程定时器")), 400);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }

    public class SchedulerPanel
        extends JPanel
    {
        private JLabel label = new JLabel("定时间隔：");
        public JNumberTextField dayTextField = new JNumberTextField(3, 0, 0, 999);
        public JLabel dayLabel = new JLabel("天");
        public JNumberTextField hourTextField = new JNumberTextField(3, 0, 0, 23);
        public JLabel hourLabel = new JLabel("小时");
        public JNumberTextField minuteTextField = new JNumberTextField(3, 0, 0, 59);
        public JLabel minuteLabel = new JLabel("分钟");
        public JNumberTextField secondTextField = new JNumberTextField(3, 0, 0, 59);
        public JLabel secondLabel = new JLabel("秒");
        public JNumberTextField milliSecondTextField = new JNumberTextField(3, 0, 0, 999);
        public JLabel milliSecondLabel = new JLabel("毫秒");

        private JButton runButton = new JButton(IconFactory.getContextIcon("run.png"));
        private JButton stopButton = new JButton(IconFactory.getContextIcon("stop.png"));
        private JTextArea textArea = new JTextArea();

//        private ScheduleExecuter scheduleExecuter = new ScheduleExecuter();
//        private CustomerSchedulerTask schedulerTask;

        public SchedulerPanel(int index)
        {
            dayTextField.setText("0");
            hourTextField.setText("0");
            minuteTextField.setText("0");
            secondTextField.setText("1");
            milliSecondTextField.setText("0");

            runButton.setEnabled(true);
            stopButton.setEnabled(false);

            double[][] size =
                {
                {0.12, 0.05, 0.03, 0.05, 0.05, 0.05, 0.05, 0.05, 0.03, 0.05, 0.05, 0.05, 0.05},
                {0.12, 0.9}
            };
            TableLayout tableLayout = new TableLayout(size);
            setLayout(tableLayout);
            setBorder(BorderFactory.createTitledBorder("Scheduler" + index));

//            runButton.addActionListener(new ActionListener()
//            {
//                public void actionPerformed(ActionEvent e)
//                {
//                    int[] intervalDayTime = {Integer.parseInt(dayTextField.getText()), Integer.parseInt(hourTextField.getText()), Integer.parseInt(minuteTextField.getText()), Integer.parseInt(secondTextField.getText()), Integer.parseInt(milliSecondTextField.getText())};
//                    schedulerTask = new CustomerSchedulerTask();
//                    scheduleExecuter.executeScheduler(schedulerTask, intervalDayTime);
//                    adaptScheduleButtonFacade(true);
//                }
//            }
//            );
//            stopButton.addActionListener(new ActionListener()
//            {
//                public void actionPerformed(ActionEvent e)
//                {
//                    schedulerTask.cancel();
//                    adaptScheduleButtonFacade(false);
//                }
//            }
//            );

            add(label, "0, 0, 0, 0");
            add(dayTextField, "1, 0, 1, 0");
            add(dayLabel, "2, 0, 2, 0");
            add(hourTextField, "3, 0, 3, 0");
            add(hourLabel, "4, 0, 4, 0");
            add(minuteTextField, "5, 0, 5, 0");
            add(minuteLabel, "6, 0, 6, 0");
            add(secondTextField, "7, 0, 7, 0");
            add(secondLabel, "8, 0, 8, 0");
            add(milliSecondTextField, "9, 0, 9, 0");
            add(milliSecondLabel, "10, 0, 10, 0");
            add(runButton, "11, 0, 11, 0");
            add(stopButton, "12, 0, 12, 0");
            add(new JScrollPane(textArea), "0, 1, 10, 1");
        }

        public void adaptScheduleButtonFacade(boolean b)
        {
            runButton.setEnabled(!b);
            stopButton.setEnabled(b);
        }

//        public class CustomerSchedulerTask
//            extends SchedulerTask
//        {
//            public CustomerSchedulerTask()
//            {
//            }
//
//            public void run()
//            {
//                textArea.setText("当前时间 ： " + TimeUtil.getCurrentHour() + " " + TimeUtil.getCurrentMinute() + " " + TimeUtil.getCurrentSecond() + " " + TimeUtil.getCurrentMillisecond());
//            }
//        }
    }
}
