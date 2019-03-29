package views

import java.awt.*
import java.awt.event.*
import javax.swing.*
import java.awt.GridBagLayout
import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.SwingConstants
import javax.swing.GroupLayout
import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.JCheckBox
import javax.swing.JTextField
import javax.swing.JLabel
import javax.swing.WindowConstants
import javax.swing.JFrame


import javax.swing.GroupLayout.Alignment.*



class MainView : JFrame() {

    private val cargarFileBtn: JButton
    private val dbfFileTable: JTable
    var menuBar: JMenuBar? = null

    init {
        this.setSize(600, 400)
        this.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        val newPanel = JPanel(GridBagLayout())

        val layout = GroupLayout(newPanel)
        newPanel.layout = layout

        layout.autoCreateGaps= true
        layout.autoCreateContainerGaps=true

        //Crear el boton
        this.cargarFileBtn = JButton("Prueba")
        this.cargarFileBtn.setBounds(30, 40, 200, 300)


        //Crear el table

        // Data to be displayed in the JTable
        val data = arrayOf(arrayOf("Kundan Kumar Jha", "4031", "CSE"), arrayOf("Anand Jha", "6014", "IT"))

        // Column Names
        val columnNames = arrayOf("Name", "Roll Number", "Department")


        this.dbfFileTable = JTable(data, columnNames)

        var scrollPane =  JScrollPane(dbfFileTable)
        dbfFileTable.fillsViewportHeight = true



        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(this.cargarFileBtn)

                            .addComponent(scrollPane)

        )
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.cargarFileBtn)

                                    .addComponent(scrollPane))
        )

        this.menuBar = JMenuBar()


        val menu = JMenu("Menú")
        menu.mnemonic = KeyEvent.VK_A
        menu.accessibleContext?.accessibleDescription =  "The only menu in this program that has menu items"
        menuBar?.add(menu)

        val menuItem = JMenuItem("A text-only menu item", KeyEvent.VK_T)
        menuItem.accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK)
        menuItem.accessibleContext?.accessibleDescription ="This doesn't really do anything"
        menu.add(menuItem)

        cargarFileBtn.addActionListener { e: ActionEvent -> this.onClickLoadFile(e) }
      /*  button1.apply {
            addActionListener(ButtonClickListener() )
            addMouseListener( ButtonMouseListener())
        }*/




        this.add(newPanel)

        newPanel.border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Login Panel")

        //this.pack()
        this.setLocationRelativeTo(null)

        this.jMenuBar = menuBar
    }


    private fun onClickLoadFile (e: ActionEvent) {

    }

/*
    private  class ButtonClickListener : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            System.out.println(e.actionCommand)
            var str = when (e.actionCommand) {
                "OK" -> {"Ok Button clicked."}
                "Submit" -> "Submit Button clicked."
                else -> "Cancel Button clicked."
            }

        }
    }




    private  class ButtonMouseListener : MouseListener {
        override fun mouseEntered(e: MouseEvent?) {
            System.out.println("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun mouseClicked(e: MouseEvent?) {
            System.out.println("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun mouseExited(e: MouseEvent?) {
            System.out.println("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun mousePressed(e: MouseEvent?) {
            System.out.println("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun mouseReleased(e: MouseEvent?) {
            System.out.println("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }*/

}
