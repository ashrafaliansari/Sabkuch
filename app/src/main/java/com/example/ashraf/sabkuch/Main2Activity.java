package com.example.ashraf.sabkuch;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button btn1,btn2;
    ProgressBar pb1,pb2;
    ProgressDialog pd1,pd2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        pb1=(ProgressBar)findViewById(R.id.progressBar2);
        pb2=(ProgressBar)findViewById(R.id.progressBar);
        pd1=new ProgressDialog(this);
        tv=(TextView)findViewById(R.id.textView);
        pd2=new ProgressDialog(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setText("horaha hai bechain mat ho!!");
                pd1.setMax(100);
                pd1.setCancelable(false);
                pd1.setMessage("ghabrao mat hojayega");
                pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd1.setProgress(0);
                pd1.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (pd1.getProgress() <= pd1.getMax()) {
                                Thread.sleep(100);
                                pd1.incrementProgressBy(1);
                                if (pd1.getProgress() == pd1.getMax()) {
                                    pd1.dismiss();
                                    Main2Activity.this.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            pd1.setProgress(0);
                                            btn1.setText("Hogaya!!!");
                                        }
                                    });
                                }

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }


        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd2.setMessage("ghar jaa re baba!!");
                pd2.setCancelable(false);
                pd2.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pd2.setIndeterminate(true);
                pd2.show();
                Handler han=new Handler();
                Runnable r=new Runnable() {
                    @Override
                    public void run() {
                        pd2.dismiss();
                        Main2Activity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                btn2.setText("isko utha le re baba!!");
                            }
                        });
                    }
                };han.postDelayed(r,3000);
                pb2.setMax(100);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int i=0;
                        while(pb2.getProgress()<=pb2.getMax()){
                            try{
                                Thread.sleep(100);
                                i++;
                                final int j=i;
                                Main2Activity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv.setText(j+"%");


                                    }
                                });
                                pb2.setProgress(i);
                                if(i==100){
                                    Main2Activity.this.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            tv.setText("AAAHHH SHaanti");
                                        }
                                    });
                                    i=0;
                                    break;
                                }
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

            }
        });


    }
}
