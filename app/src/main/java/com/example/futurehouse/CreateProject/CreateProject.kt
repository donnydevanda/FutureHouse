package com.example.futurehouse.CreateProject

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.futurehouse.R
import com.example.futurehouse.Utils.Preferences
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_create_project.*
import kotlinx.android.synthetic.main.activity_create_project.btn_back
import kotlinx.android.synthetic.main.activity_create_project.text_back
import java.util.*


class CreateProject : AppCompatActivity(), View.OnClickListener, PermissionListener {

    val REQUEST_IMAGE_CAPTURE = 1
    var statusAdd2:Boolean = false
    var checker:Boolean = false
    lateinit var filePath: Uri

    lateinit var storage: FirebaseStorage
    lateinit var storageReference: StorageReference
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_project)

        preferences = Preferences(this)
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        iv_add_cp.setOnClickListener {
            if (statusAdd2) {
                statusAdd2 = false
                iv_add_cp.setImageResource(R.drawable.ic_btn_upload)
                iv_profile_cp.setImageResource(R.drawable.ic_user)
                checker = false
            } else {
                ImagePicker.with(this)
                    .cropSquare()
                    .compress(1024)			//Final image size will be less than 1 MB(Optional)
                    .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                    .start()
            }
        }

        btn_save_cp.setOnClickListener {
            if (statusAdd2 == true){
                if (filePath != null) {
                    val progressDialog = ProgressDialog(this)
                    progressDialog.setTitle("Uploading...")
                    progressDialog.show()

                    val ref = storageReference.child("projects/" + UUID.randomUUID().toString())
                    ref.putFile(filePath)
                        .addOnSuccessListener {
                            progressDialog.dismiss()
                            Toast.makeText(this@CreateProject, "Uploaded", Toast.LENGTH_SHORT).show()

                            ref.downloadUrl.addOnSuccessListener {
                                preferences.setValues("link", it.toString())
                            }
                        }
                        .addOnFailureListener { e ->
                            progressDialog.dismiss()
                            Toast.makeText(this@CreateProject, "Failed " + e.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                        .addOnProgressListener { taskSnapshot ->
                            val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot
                                .totalByteCount
                            progressDialog.setMessage("Uploaded " + progress.toInt() + "%")
                        }
                    checker = true
                }
            } else{
                checker = false
                Toast.makeText(this, "Please Upload Picture", Toast.LENGTH_SHORT).show()
            }
        }

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_next_cp)
        btnMoveWithDataActivity.setOnClickListener(this)

        btn_back.setOnClickListener {
            val intent = Intent(
                this@CreateProject,
                CreateProjectReview::class.java
                )
            startActivity(intent)
           }

        text_back.setOnClickListener {
            val intent = Intent(
                this@CreateProject,
                CreateProjectReview::class.java
            )
            startActivity(intent)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_next_cp -> {
                if (checker==true){
                    btn_next_cp.setOnClickListener {
                        val moveWithDataIntent =
                            Intent(this@CreateProject, CreateProjectReview::class.java)
                        moveWithDataIntent.putExtra(
                            CreateProjectReview.getTitle,
                            project_title.text.toString()
                        )
                        moveWithDataIntent.putExtra(
                            CreateProjectReview.getDesc,
                            project_desc.text.toString()
                        )
                        moveWithDataIntent.putExtra(
                            CreateProjectReview.getAddress,
                            project_address.text.toString()
                        )
                        moveWithDataIntent.putExtra(
                            CreateProjectReview.getDuration,
                            project_duration.text.toString()
                        )
                        moveWithDataIntent.putExtra(
                            CreateProjectReview.getImage,
                            preferences.getValues("link")
                        )
                        startActivity(moveWithDataIntent)
                    }
                } else{
                    Toast.makeText(this, "Please Save Picture", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onPermissionGranted(response: PermissionGrantedResponse?) {
        //To change body of created functions use File | Settings | File Templates.
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }

    }

    override fun onPermissionRationaleShouldBeShown(
        permission: com.karumi.dexter.listener.PermissionRequest?,
        token: PermissionToken?
    ) {
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPermissionDenied(response: PermissionDeniedResponse?) {
        //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(this, "You cant add profile photo", Toast.LENGTH_LONG ).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            statusAdd2 = true
            filePath = data?.data!!
            Glide.with(this)
                .load(filePath)
                .apply(RequestOptions.circleCropTransform())
                .into(iv_profile_cp)

            iv_add_cp.setImageResource(R.drawable.ic_btn_delete)

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
}
