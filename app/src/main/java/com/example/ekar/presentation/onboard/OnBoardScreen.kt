package com.example.ekar.presentation.onboard

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import com.example.ekar.R
import com.example.ekar.presentation.EkarViewModel
import com.example.ekar.presentation.component.ActionAppBar
import com.example.ekar.presentation.component.ComposeButton
import com.example.ekar.presentation.component.ComposeEditText
import com.example.ekar.presentation.theme.DARK_GREY
import com.example.ekar.presentation.theme.spacerHeight
import com.example.ekar.presentation.theme.spacerWidth
import com.example.ekar.presentation.theme.spacing

@Composable
fun ViewOnBoardScreen(
    viewModel: EkarViewModel,
    onNavigateUp: () -> Unit,
) {
    val context = LocalContext.current

    var text by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }

    var selectedImageUri1 by remember {
        mutableStateOf<Uri?>(null)
    }
    var selectedImageUri2 by remember {
        mutableStateOf<Uri?>(null)
    }
    var selectedImageUri3 by remember {
        mutableStateOf<Uri?>(null)
    }
    var selectedImageUri4 by remember {
        mutableStateOf<Uri?>(null)
    }

    var selectedImageNumber = 1

    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            when (selectedImageNumber) {
                1 -> {
                    selectedImageUri1 = uri
                }
                2 -> {
                    selectedImageUri2 = uri
                }
                3 -> {
                    selectedImageUri3 = uri
                }
                4 -> {
                    selectedImageUri4 = uri
                }
            }

        }
    )
    Scaffold(
        topBar = {
            ActionAppBar(
                title = context.getString(R.string.ekar),
                backEnabled = true,
                leadingIcon = Icons.Filled.Close,
                ) {
                onNavigateUp()

            }
        },
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.spacing.view_4x)
                    .weight(1f)
            ) {
                item {
                    Text(
                        text = stringResource(R.string.image_upload_msg_description),
                        style = MaterialTheme.typography.caption,
                        color = DARK_GREY,
                        fontWeight = FontWeight.Normal,
                    )
                    spacerHeight(height = MaterialTheme.spacing.view_4x)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Box(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            AsyncImage(
                                model = selectedImageUri1,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable {
                                        selectedImageNumber = 1
                                        singlePhotoPickerLauncher.launch(
                                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                        )
                                    },
                                contentScale = ContentScale.Crop,
                                fallback = painterResource(R.drawable.front_left),
                            )
                        }
                        spacerWidth(width = MaterialTheme.spacing.view_2x)
                        Box(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            AsyncImage(
                                model = selectedImageUri2,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable {
                                        selectedImageNumber = 2
                                        singlePhotoPickerLauncher.launch(
                                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                        )
                                    },
                                contentScale = ContentScale.Crop,
                                fallback = painterResource(R.drawable.front_right),
                            )
                        }
                    }
                    spacerHeight(height = MaterialTheme.spacing.view_2x)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Box(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            AsyncImage(
                                model = selectedImageUri3,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable {
                                        selectedImageNumber = 3
                                        singlePhotoPickerLauncher.launch(
                                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                        )
                                    },
                                contentScale = ContentScale.Crop,
                                fallback = painterResource(R.drawable.back_left),
                            )
                        }
                        spacerWidth(width = MaterialTheme.spacing.view_2x)
                        Box(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            AsyncImage(
                                model = selectedImageUri4,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable {
                                        selectedImageNumber = 4
                                        singlePhotoPickerLauncher.launch(
                                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                        )
                                    },
                                contentScale = ContentScale.Crop,
                                fallback = painterResource(R.drawable.back_right),
                            )
                        }
                    }
                    spacerHeight(height = MaterialTheme.spacing.view_4x)
                    ComposeEditText(
                        text = text,
                        hintText = context.getString(R.string.enter_comment),
                        isError = isError,
                        errorMessage = "Length should not be greater than 20",
                    ) {
                        text = it
                        isError = text.length > 20

                    }
                }
            }
            ComposeButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.spacing.view_4x),
                innerPadding = MaterialTheme.spacing.view_2x,
                buttonText = "Submit"
            ) {
                if (selectedImageUri1 == null ||
                    selectedImageUri2 == null ||
                    selectedImageUri3 == null ||
                    selectedImageUri4 == null ||
                    text.isEmpty()
                ) {
                    Toast.makeText(context, "Please fill all the fields.", Toast.LENGTH_SHORT)
                        .show()
                    return@ComposeButton
                }
                Toast.makeText(context, "Thank you for choosing ekar.", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
}