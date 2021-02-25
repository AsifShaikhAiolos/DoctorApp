package com.twilio.video.docapp.util

import android.app.Activity
import android.app.Dialog
import android.util.Base64
import android.view.WindowManager
import com.twilio.video.docapp.R
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class Crypto {

    fun encrypt(plaintext: ByteArray?, key: String): String? {
        val IV = "0000000000000000"
        val cipher: Cipher = Cipher.getInstance("AES")
        val ivSpec = IvParameterSpec(IV.toByteArray())

        val keyb: ByteArray = key.toByteArray(StandardCharsets.UTF_8)
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(keyb)

        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(digest, "AES"), ivSpec)
        return Base64.encodeToString(cipher.doFinal(plaintext), Base64.DEFAULT)
    }

    fun decrypt(cipherText: String?, key: String): String? {
        val IV = "0000000000000000"
        try {
            val cipher = Cipher.getInstance("AES")
            val ivSpec = IvParameterSpec(IV.toByteArray())

            val keyb: ByteArray = key.toByteArray(StandardCharsets.UTF_8)
            val md = MessageDigest.getInstance("SHA-256")
            val digest = md.digest(keyb)

            cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(digest, "AES"), ivSpec)
            val decryptedText = cipher.doFinal(Base64.decode(cipherText, Base64.DEFAULT))
            return String(decryptedText)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

//    fun showAlertMessage(msg: String, activity:Activity) {
//        lateinit var dialog: Dialog
//        if (activity != null) {
//            dialog = Dialog(activity, R.style.Dialog)
//            dialog.setContentView(R.layout.error_msg_box)
//            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
//                    WindowManager.LayoutParams.WRAP_CONTENT)
//            dialog.setCancelable(false)
//            dialog
//        }
//    }

}