import java.awt.BorderLayout
import javax.swing.*
import java.awt.SystemColor.menu
import javax.swing.JMenu
import javax.swing.JMenuBar
import java.awt.SystemColor.menu
import java.awt.event.*
import javax.swing.KeyStroke
import javax.swing.JMenuItem
import java.awt.FlowLayout



class Princ : JFrame() {

    private val button1: JButton
    var menuBar: JMenuBar? = null

    init {
        this.setSize(600, 400)
        this.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        this.layout = FlowLayout()

        this.button1 = JButton("Prueba")
        this.button1.setBounds(0, 0, 120, 120)

        this.add(this.button1, BorderLayout.NORTH)


        menuBar = JMenuBar()


        val menu = JMenu("Menú")
        menu.mnemonic = KeyEvent.VK_A
        menu.accessibleContext?.accessibleDescription =  "The only menu in this program that has menu items"
        menuBar?.add(menu)

        val menuItem = JMenuItem("A text-only menu item", KeyEvent.VK_T)
        menuItem.accelerator =KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK)
        menuItem.accessibleContext?.accessibleDescription ="This doesn't really do anything"
        menu.add(menuItem)

        button1.addActionListener { e: ActionEvent -> run { System.out.println("sdfsdf") } }
        button1.apply {
            addActionListener(ButtonClickListener() )
            addMouseListener( ButtonMouseListener())
        }


        this.jMenuBar = menuBar
    }
}

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
}


fun main(args: Array<String>) {
    val frame = Princ()
    frame.isVisible = true
}