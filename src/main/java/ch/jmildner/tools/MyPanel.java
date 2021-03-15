
package ch.jmildner.tools;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * The class <code>MyPanel</code> makes GUI-Programming easier.
 * It uses Swing-Panels and GridBagLayout.
 *
 * <pre>
 *
 *   A sample
 *
 *   +---------------------------------------------------------------+
 *   !   1   |   2   |   3   |   4   |   5   |   6   |   7   |   8   |
 *   +---------------------------------------------------------------+
 *  1!                                                               |
 *  2!            U E B E R S C H R I F T                            |
 *  3!                                                               |
 *  4!name:   _______________________                                |
 *  5!value:  ________________________________________               |
 *  6!                                                               |
 *  7!       ------------------------------------------------------- |
 *  8!       |                                                     | |
 *  9!data:  |                                                     | |
 * 10!       |                                                     | |
 * 11!       ------------------------------------------------------- |
 * 12!                                                               |
 * 13!BUTTON1 BUTTON2 BUTTON3                             BUTTON9    |
 * 14!                                                               |
 *   +---------------------------------------------------------------+
 *
 *      int columns = 8;
 *      int widthOfColumn = 7;
 *
 *
 *      JButton random = new JButton("execute");
 *      JButton clear = new JButton("clear");
 *      JButton end = new JButton("end");
 *      JTextField tfName = new JTextField("", 15);
 *      JTextField tfValue = new JTextField("", 15);
 *      JTextArea taResult = new JTextArea(3, 15);
 *
 *      MyPanel mp = new MyPanel(columns, widthOfColumn, true);
 *
 *      mp.addCaptionCenter("TOPIC", 2, 1, 8);
 *
 *      mp.add(new JLabel("Name"), 4, 1, 1);
 *      mp.add(tfName, 4, 2, 3);
 *
 *      mp.add(new JLabel("Value"), 5, 1, 1);
 *      mp.add(tfValue, 5, 2, 5);
 *
 *      mp.add(new JLabel("Result"), 8, 1, 1);
 *      mp.addTextArea(taResult, 7, 2, 7, 3);
 *
 *      mp.add(random, 13, 1, 1);
 *      mp.add(clear, 13, 2, 1);
 *      mp.add(end, 13, 3, 1);
 *
 *      JFrame frame = new JFrame();
 *      frame.add(mp);
 *      frame.pack();
 *
 *      frame.setLocation(400, 500);
 *
 *      frame.setVisible(true);
 *
 *      frame.addWindowListener(new WindowAdapter()
 *      {
 *          public void windowClosing(WindowEvent we)
 *          {
 *              System.exit(0);
 *          }
 *      });
 *   ----------------------------------------------------------------
 * </pre>
 *
 * @author Johann Mildner, Basel - &copy; java-akademie.ch
 */
public class MyPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private Insets insets;

    public static void main(String[] args) {
        MyTools.h1("shows how to use MyPanel and prevents unused warnings");
        int columns = 8;
        int widthOfColumn = 12;

        JButton random = new JButton("execute");
        JButton clear = new JButton("clear");
        JButton end = new JButton("end");
        JTextField tfName = new JTextField("", 15);
        JTextField tfValue = new JTextField("", 15);
        JTextArea taResult = new JTextArea(3, 15);

        // to omit the not used warnings
        MyPanel dummy = new MyPanel();
        dummy.init(1, 1);
        dummy.addCenter(new JLabel("a"), 1, 1, 1);
        dummy.addLabelCenter("b", 1, 2, 1);
        dummy.addLabelRight("c", 1, 3, 1);
        dummy.addLabelLeft("d", 1, 4, 1);
        dummy.addLabel("d", 1, 4, 1);
        dummy.addEmptyGrid(1, ' ', 1, 1);
        dummy.addLeft(new JLabel("e"), 1, 1, 1);
        dummy.addRight(new JLabel("e"), 1, 1, 1);
        new MyPanel(1, 1);
        // to omit not used warnings

        MyPanel mp = new MyPanel(columns, widthOfColumn, true);

        mp.addCaptionCenter("How to use MyPanel", 2, 1, 8);

        mp.add(new JLabel("Name"), 4, 1, 1);
        mp.add(tfName, 4, 2, 3);

        mp.add(new JLabel("Value"), 5, 1, 1);
        mp.add(tfValue, 5, 2, 5);

        mp.add(new JLabel("Result"), 8, 1, 1);
        mp.addTextArea(taResult, 7, 2, 7, 3);

        mp.add(random, 15, 1, 1);
        mp.add(clear, 15, 2, 1);
        mp.addLabel(" ", 16, 1, 1);
        mp.addLabel(" ", 21, 1, 1);
        mp.add(end, 25, 1, 1);

        mp.addEmptyGrid(12, 'x', 1, 8);
        mp.addEmptyRow(12, '$', 1, 8);

        JFrame frame = new JFrame();
        frame.add(mp);
        frame.pack();

        frame.setLocation(400, 500);

        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    /**
     * Constructor.
     */
    public MyPanel() {
    }

    /**
     * Constructor.
     *
     * @param numberOfColumns number of columns
     * @param widthOfColumn   width of columns
     */
    public MyPanel(int numberOfColumns, int widthOfColumn) {
        init(numberOfColumns, widthOfColumn, false);
    }

    /**
     * Constructor.
     *
     * @param numberOfColumns number of columns
     * @param widthOfColumn   width of columns
     * @param test            true=Test, false=Production
     */
    public MyPanel(int numberOfColumns, int widthOfColumn, boolean test) {
        init(numberOfColumns, widthOfColumn, test);
    }

    /**
     * init
     */
    public final void init() {
        this.insets = new Insets(4, 4, 4, 4);
        this.setLayout(new GridBagLayout());
    }

    /**
     * Init.
     *
     * @param columns number of columns
     * @param width   width of column
     * @param test    true=Test, false=Production
     */
    public final void init(int columns, int width, boolean test) {
        this.init();
        this.addEmptyRow(width, (test ? '.' : ' '), 1, columns);
    }

    /**
     * Init.
     *
     * @param columns number of columns
     * @param with    width of column
     */
    public final void init(int columns, int with) {
        this.init(columns, with, false);
    }

    /**
     * Adds a component left.
     *
     * @param component component
     * @param row       rowNumber
     * @param column    columnNumber
     * @param width     number of columns concatenated
     */
    public void add(JComponent component, int row, int column, int width) {
        add(component, row, column, width, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL);
    }

    /**
     * Adds a component.
     *
     * @param component component
     * @param row       rowNumber
     * @param column    columnNumber
     * @param width     number of columns concatenated
     * @param height    number of lines concatenated
     */
    public void add(JComponent component, int row, int column, int width, int height) {
        add(component, row, column, width, height, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL);
    }

    /**
     * Adds a component.
     *
     * @param component component
     * @param row       rowNumber
     * @param column    columnNumber
     * @param width     number of columns concatenated
     * @param height    number of lines concatenated
     * @param alignment alignment (WEST, EAST, CENTER ...)
     * @param fill      fill (HORIZONTAL, NONE ...)
     */
    private void add(JComponent component, int row, int column, int width, int height, int alignment, int fill) {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = insets;

        gbc.gridx = column - 1;
        gbc.gridy = row - 1;
        gbc.gridwidth = width;
        gbc.gridheight = height;

        gbc.anchor = alignment;
        gbc.fill = fill;
        gbc.weightx = 0;
        gbc.weighty = 0;

        ((GridBagLayout) this.getLayout()).setConstraints(component, gbc);

        add(component);
    }

    /**
     * Adds a text as centered topic.
     *
     * @param text   the Text
     * @param row    rowNumber
     * @param column columnNumber
     * @param width  number of columns centered
     */
    public void addCaptionCenter(String text, int row, int column, int width) {
        JLabel l = mkJLabel(text, new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(l, row, column, width, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
    }

    /**
     * Adds a component centered.
     *
     * @param component component
     * @param row       rowNumber
     * @param column    columnNumber
     * @param width     number of columns centered
     */
    public void addCenter(JComponent component, int row, int column, int width) {
        add(component, row, column, width, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
    }

    /**
     * Fills the Grid with equal texts.
     * Useful for testing.
     *
     * @param width   number of fillingSigns in the text field
     * @param filler  filling sign
     * @param rows    number of rows to fill
     * @param columns number of columns to fill
     */
    public void addEmptyGrid(int width, char filler, int rows, int columns) {
        StringBuilder text = new StringBuilder();

        for (int i = 1; i <= width; i++)
            text.append(filler);

        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12);

        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                add(mkJLabel(text.toString(), font), row * 10, column, 1);
            }
        }

    }

    /**
     * Fills the rows with equal texts.
     * Useful for testing.
     *
     * @param width   number of fillingSigns in the text field
     * @param filler  filling sign
     * @param rows    number of rows to fill
     * @param columns number of columns to fill
     */
    public void addEmptyRow(int width, char filler, int rows, int columns) {
        StringBuilder text = new StringBuilder();

        for (int i = 1; i <= width; i++)
            text.append(filler);

        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12);

        for (int column = 1; column <= columns; column++) {
            add(mkJLabel(text.toString(), font), rows, column, 1);
        }
    }

    /**
     * Adds a text as label.
     *
     * @param text   the text
     * @param row    rowNumber
     * @param column columnNumber
     * @param width  number of concatenated columns
     */
    public void addLabel(String text, int row, int column, int width) {
        addLabelLeft(text, row, column, width);
    }

    /**
     * Adds a text as label centered.
     *
     * @param text   the text
     * @param row    rowNumber
     * @param column columnNumber
     * @param width  number of concatenated columns
     */
    public void addLabelCenter(String text, int row, int column, int width) {
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        add(l, row, column, width);
    }

    /**
     * Adds a text as label left.
     *
     * @param text   the text
     * @param row    rowNumber
     * @param column columnNumber
     * @param width  number of concatenated columns
     */
    public void addLabelLeft(String text, int row, int column, int width) {
        JLabel l = new JLabel(text, SwingConstants.LEFT);
        add(l, row, column, width);
    }

    /**
     * Adds a text as label right.
     *
     * @param text   the text
     * @param row    rowNumber
     * @param column columnNumber
     * @param width  number of concatenated columns
     */
    public void addLabelRight(String text, int row, int column, int width) {
        JLabel l = new JLabel(text, SwingConstants.RIGHT);
        add(l, row, column, width);
    }

    /**
     * Adds a component left.
     *
     * @param component the component
     * @param row       rowNumber
     * @param column    columnNumber
     * @param width     number of concatenated columns
     */
    public void addLeft(JComponent component, int row, int column, int width) {
        add(component, row, column, width, 1,
                GridBagConstraints.WEST, GridBagConstraints.NONE);
    }

    /**
     * Adds a component right.
     *
     * @param component the component
     * @param row       rowNumber
     * @param column    columnNumber
     * @param width     number of concatenated columns
     */
    public void addRight(
            JComponent component, int row, int column, int width) {
        add(component, row, column, width, 1,
                GridBagConstraints.EAST, GridBagConstraints.NONE);
    }

    /**
     * Adds a scrollable text area.
     *
     * @param textArea the text area
     * @param row      rowNumber
     * @param column   columnNumber
     * @param width    number of concatenated columns
     * @param height   number of concatenated lines
     */
    public void addTextArea(
            JTextArea textArea, int row, int column, int width, int height) {
        textArea.setLineWrap(true);
        textArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        JScrollPane sp = new JScrollPane(textArea);
        add(sp, row, column, width, height);
    }


    /**
     * Makes a label.
     *
     * @param text the text
     * @param font the font
     * @return the label
     */
    private JLabel mkJLabel(String text, Font font) {
        JLabel lb = new JLabel(text);
        lb.setFont(font);
        return lb;
    }
}

