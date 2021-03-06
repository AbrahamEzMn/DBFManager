package dbf

import com.linuxense.javadbf.*
import java.io.FileInputStream
import java.io.IOException
import java.io.FileOutputStream
import com.linuxense.javadbf.DBFWriter
import java.lang.Exception


class DbfController {


    fun readFile (filePath: String): DbfFile? {
        var dbfFile: DbfFile? = null
        var dbfReader : DBFReader? = null

        try {

            dbfReader = DBFReader(FileInputStream(filePath))
            dbfFile = DbfFile()
            dbfFile.headers = this.readHeaders(dbfReader)
            dbfFile.rows = this.readRows(dbfReader)
        }
         catch (e: DBFException) {
            //e.printStackTrace()
        } catch (e: IOException) {
           // e.printStackTrace()
        }
        finally {
            DBFUtils.close(dbfReader)
        }


        return dbfFile
    }

    fun writeFile(path: String, dbfFile: DbfFile) : Boolean {

        try {
            val writer = DBFWriter(FileOutputStream(path))

            writer.setFields(dbfFile.headers!!.toTypedArray())

            for (row in dbfFile.rows!!.toTypedArray()) {
                writer.addRecord(row)
            }

            writer.close()

            return true
        }
        catch (e:Exception){
            e.printStackTrace()
        }

        return false
    }

    private fun readHeaders(dbfReader:DBFReader): ArrayList<DBFField> {

        var headers : ArrayList<DBFField> = ArrayList()

        for (i in 0 until dbfReader.fieldCount) {

            var field = dbfReader.getField(i)
            headers.add(field)
            //println(field.name)
        }

        return headers
    }

    private fun readRows(dbfReader: DBFReader): ArrayList<Array<Any>> {

        var data:ArrayList<Array<Any>> = ArrayList()
        var rowObjects: Array<Any>

        while (true) {

            rowObjects = dbfReader.nextRecord() ?: break

            data.add(rowObjects)
            for (i in rowObjects.indices) {
                //println(rowObjects[i])
            }
        }

        return data
    }
}