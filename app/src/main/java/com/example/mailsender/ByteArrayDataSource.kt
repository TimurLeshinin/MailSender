package com.example.mailsender

import kotlin.Throws
import com.example.mailsender.JSSEProvider
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import kotlin.jvm.Synchronized
import javax.mail.internet.MimeMessage
import javax.activation.DataHandler
import javax.activation.DataSource
import javax.mail.internet.InternetAddress

class ByteArrayDataSource : DataSource {
    private var data: ByteArray
    private var type: String? = null

    constructor(data: ByteArray, type: String?) : super() {
        this.data = data
        this.type = type
    }

    constructor(data: ByteArray) : super() {
        this.data = data
    }

    fun setType(type: String?) {
        this.type = type
    }

    override fun getContentType(): String {
        return         if (type == null) "application/octet-stream"
        else type!!
    }

    @Throws(IOException::class)
    override fun getInputStream(): InputStream {
        return ByteArrayInputStream(data)
    }

    override fun getName(): String {
        return "ByteArrayDataSource"
    }

    @Throws(IOException::class)
    override fun getOutputStream(): OutputStream {
        throw IOException("Not Supported")
    }
}