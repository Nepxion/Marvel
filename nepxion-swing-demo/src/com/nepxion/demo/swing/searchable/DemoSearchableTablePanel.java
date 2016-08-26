package com.nepxion.demo.swing.searchable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import com.nepxion.swing.layout.table.*;
import com.nepxion.swing.searchable.*;
import com.nepxion.swing.statusbar.*;

public class DemoSearchableTablePanel
    extends JPanel
{
    public DemoSearchableTablePanel()
    {
        double[][] size =
            {
            {TableLayout.FILL},
            {0.5, 0.5}
        };
        TableLayout tableLayout = new TableLayout(size);
        JPanel panel = new JPanel();
        panel.setLayout(tableLayout);
        panel.add(createTable(), "0, 0");
        panel.add(createTableContainer(), "0, 1");

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" °´CTRL+Fºô³ö²éÑ¯¿ò")), 400);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }

    private JScrollPane createTable()
    {
        JTable table = new JTable(new QuoteTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(200, 100));
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);

        JSearchableFactory.installSearchable(table);
        return new JScrollPane(table);
    }

    private JSearchableContainer createTableContainer()
    {
        JTable table = new JTable(new QuoteTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(200, 100));
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);

        JSearchableContainer container = new JSearchableContainer();
        container.add(new JScrollPane(table));
        JSearchableFactory.installSearchableBar(table, container);
        return container;
    }

    static String[] QUOTE_COLUMNS = new String[]
                                    {
                                    "Symbol", "Name", "Last", "Change", "Volume"};

    static Object[][] QUOTES = new Object[][]
                               {
                               new Object[]
                               {"AA", "ALCOA INC", "32.88", "+0.53 (1.64%)", "4156200"},
                               new Object[]
                               {"AIG", "AMER INTL GROUP", "69.53", "\uFFFD-0.58 (0.83%)", "4369200"},
                               new Object[]
                               {"AXP", "AMER EXPRESS CO", "48.90", "\uFFFD-0.35 (0.71%)", "4103600"},
                               new Object[]
                               {"BA", "BOEING CO", "49.14", "\uFFFD-0.18 (0.36%)", "3573700"},
                               new Object[]
                               {"C", "CITIGROUP", "44.21", "\uFFFD-0.89 (1.97%)", "28594900"},
                               new Object[]
                               {"CAT", "CATERPILLAR INC", "79.40", "+0.62 (0.79%)", "1458200"},
                               new Object[]
                               {"DD", "DU PONT CO", "42.62", "\uFFFD-0.14 (0.33%)", "1832700"},
                               new Object[]
                               {"DIS", "WALT DISNEY CO", "23.87", "\uFFFD-0.32 (1.32%)", "4443600"},
                               new Object[]
                               {"GE", "GENERAL ELEC CO", "33.37", "+0.24 (0.72%)", "31429500"},
                               new Object[]
                               {"GM", "GENERAL MOTORS", "43.94", "\uFFFD-0.20 (0.45%)", "3722100"},
                               new Object[]
                               {"HD", "HOME DEPOT INC", "34.33", "\uFFFD-0.18 (0.52%)", "5367900"},
                               new Object[]
                               {"HON", "HONEYWELL INTL", "35.70", "+0.23 (0.65%)", "4092100"},
                               new Object[]
                               {"HPQ", "HEWLETT-PACKARD", "19.65", "\uFFFD-0.25 (1.26%)", "11003000"},
                               new Object[]
                               {"IBM", "INTL BUS MACHINE", "84.02", "\uFFFD-0.11 (0.13%)", "6880500"},
                               new Object[]
                               {"INTC", "INTEL CORP", "23.15", "\uFFFD-0.23 (0.98%)", "95177008"},
                               new Object[]
                               {"JNJ", "JOHNSON&JOHNSON", "55.35", "\uFFFD-0.57 (1.02%)", "5428000"},
                               new Object[]
                               {"JPM", "JP MORGAN CHASE", "36.00", "\uFFFD-0.45 (1.23%)", "12135300"},
                               new Object[]
                               {"KO", "COCA COLA CO", "50.84", "\uFFFD-0.32 (0.63%)", "4143600"},
                               new Object[]
                               {"MCD", "MCDONALDS CORP", "27.91", "+0.12 (0.43%)", "6110800"},
                               new Object[]
                               {"MMM", "3M COMPANY", "88.62", "+0.43 (0.49%)", "2073800"},
                               new Object[]
                               {"MO", "ALTRIA GROUP", "48.20", "\uFFFD-0.80 (1.63%)", "6005500"},
                               new Object[]
                               {"MRK", "MERCK & CO", "44.71", "\uFFFD-0.97 (2.12%)", "5472100"},
                               new Object[]
                               {"MSFT", "MICROSOFT CP", "27.87", "\uFFFD-0.26 (0.92%)", "46717716"},
                               new Object[]
                               {"PFE", "PFIZER INC", "32.58", "\uFFFD-1.43 (4.20%)", "28783200"},
                               new Object[]
                               {"PG", "PROCTER & GAMBLE", "55.01", "\uFFFD-0.07 (0.13%)", "5538400"},
                               new Object[]
                               {"SBC", "SBC COMMS", "23.00", "\uFFFD-0.54 (2.29%)", "6423400"},
                               new Object[]
                               {"UTX", "UNITED TECH CP", "91.00", "+1.16 (1.29%)", "1868600"},
                               new Object[]
                               {"VZ", "VERIZON COMMS", "34.81", "\uFFFD-0.35 (1.00%)", "4182600"},
                               new Object[]
                               {"WMT", "WAL-MART STORES", "52.33", "\uFFFD-0.25 (0.48%)", "6776700"},
                               new Object[]
                               {"XOM", "EXXON MOBIL", "45.32", "\uFFFD-0.14 (0.31%)", "7838100"}
    };

    public static class QuoteTableModel
        extends DefaultTableModel
    {
        public QuoteTableModel()
        {
            super(QUOTES, QUOTE_COLUMNS);
        }

        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    }
}
