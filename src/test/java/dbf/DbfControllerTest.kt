package dbf


import org.junit.Test
import java.nio.file.Paths
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull


class DbfControllerTest {
    private val path = Paths.get("").toAbsolutePath().toString()

    @Test
    fun `ReadFile - Archivo correcto`() {

        val dbfController = DbfController()
        println(path)
        val file = dbfController.readFile("$path/src/test/java/dbf/sample.dbf")
        assertNotNull(file)
    }

    @Test fun `ReadFile - Archivo no existente`() {

        val dbfController = DbfController()

        val file = dbfController.readFile("$path/src/test/java/dbf/archivoNoExistente.dbf")
        assertNull(file)
    }
}

