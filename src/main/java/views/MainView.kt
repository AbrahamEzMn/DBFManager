package views

import dbf.DbfController
import dbf.DbfFile
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
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter
import javax.swing.table.TableModel
import javax.swing.table.DefaultTableModel




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
        this.cargarFileBtn = JButton("Cargar DBF")
        this.cargarFileBtn.setBounds(30, 40, 200, 300)


        //Crear el table
        this.dbfFileTable = JTable()

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

        this.add(newPanel)

        //newPanel.border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Login Panel")

        this.pack()
        this.setLocationRelativeTo(null)

        this.jMenuBar = menuBar
    }


    private fun onClickLoadFile (e: ActionEvent) {
        val chooser = JFileChooser()
        val filter = FileNameExtensionFilter("DBF Files", "dbf")
        chooser.fileFilter = filter
        val returnVal = chooser.showOpenDialog(parent)
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            var file : DbfFile = DbfController().readFile(chooser.selectedFile.path)!!

            var model = DefaultTableModel()

            file!!.headers?.forEach { model.addColumn(it) }
            file!!.rows?.forEach { model.addRow(it) }

            this.dbfFileTable.model = model
        }
    }
}
