package cn.bmob.imdemo.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import cn.bmob.imdemo.R;
import cn.bmob.imdemo.WrhImageView;
import cn.bmob.imdemo.base.ParentWithNaviActivity;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Keqin Chen on 2017/10/2.
 */

public class TestActvity extends ParentWithNaviActivity implements View.OnClickListener{
    private String mFilePath;
    private static int REQUEST_CODE_FROM_CAMERA = 1;
    private static int REQUEST_CODE_FROM_ALBUM = 2;
    private WrhImageView wrhImageView;
    private ImageView imageView;
    private Button btnClip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
         initNaviView();
        mFilePath = Environment.getExternalStorageDirectory().getPath();// 获取SD卡路径
        mFilePath = mFilePath + "/" + "temp.png";// 指定路径
       // CircleImageView circleImageView = (CircleImageView) findViewById(R.id.circleview);
    //    circleImageView.setOnClickListener(this);

        imageView = (ImageView)findViewById(R.id.img2);
        btnClip = (Button)findViewById(R.id.btn_clip);
        btnClip.setOnClickListener(this);
        wrhImageView = (WrhImageView)findViewById(R.id.img);
        wrhImageView.setImageResource(R.mipmap.head);

    }

    @Override
    public void onClick(View v) {
  /*      String title = "选择获取图片方式";
        String[] items = new String[]{"拍照","相册"};
        new AlertDialog.Builder(TestActvity.this)
                .setTitle(title)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                        switch (which){
                            case 0:
                                //选择拍照
                                pickImageFromCamera(TestActvity.this);

                                break;
                            case 1:
                                //选择相册
                                pickImageFromAlbum(TestActvity.this);
                                break;
                            default:
                                break;
                        }
                    }
                }).show();
*/
        wrhImageView.setVisibility(View.INVISIBLE);
        Bitmap bitmap = wrhImageView.clipBitmap();
        imageView.setImageBitmap(bitmap);

    }




    public  void pickImageFromCamera(final Activity activity){
        //获得指定路径的Uri
        Uri  imageUriFromCamera =  Uri.fromFile(new File(mFilePath)); // 传递路径

        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUriFromCamera);
        activity.startActivityForResult(intent,REQUEST_CODE_FROM_CAMERA);
    }
    public static void pickImageFromAlbum(final Activity activity){

        //隐式调用，可能出现多种选择
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        activity.startActivityForResult(intent,REQUEST_CODE_FROM_ALBUM);
    }
    @Override
    protected String title() {
        return "For test";
    }
}
