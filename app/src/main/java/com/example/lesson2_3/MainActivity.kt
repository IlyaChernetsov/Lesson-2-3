package com.example.lesson2_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.content.Intent

import android.net.Uri
import android.provider.MediaStore

import android.view.View
import android.widget.TextView
import androidx.core.app.ShareCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun openWebsite(view: View) {
        var mWebsiteEditText:TextView = findViewById(R.id.website_edittext);
        // Get the URL text.
        val url: String = mWebsiteEditText.text.toString()

        // Parse the URI and create the intent.
//        val webpage = Uri.parse(url)
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)

        // Find an activity to hand the intent and start that activity.
//        if (intent.resolveActivity(packageManager) != null) {
//            startActivity(intent)
//        } else {
//            Log.d("ImplicitIntents", "Can't handle this intent!")
//        }
    }
    fun openLocation(view: View) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        var mLocationEditText:TextView = findViewById(R.id.location_edittext);
        val loc: String = mLocationEditText.text.toString()

        // Parse the location and create the intent.
        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }
    fun shareText(view: View){
        var mShareTextEditText:TextView = findViewById(R.id.share_edittext);
        val txt: String = mShareTextEditText.text.toString()
        var mimeType:String = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle("Share this text with: ")
            .setText(txt)
            .startChooser();
    }
    fun takePic(view: android.view.View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE)
        startActivity(intent)
    }

}