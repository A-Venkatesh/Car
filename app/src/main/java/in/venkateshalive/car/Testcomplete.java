package in.venkateshalive.car;

import android.content.Intent;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Testcomplete extends AppCompatActivity {
    private TextToSpeech TTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testcomplete);

        TextView enteredText = (TextView) findViewById(R.id.key);
        String words = enteredText.getText().toString();

        if(words.length()!=0){
            StartSpeak(words);
        }
    }

    private void StartSpeak(final String data) {

        TTS=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int initStatus) {
                if (initStatus == TextToSpeech.SUCCESS) {
                    if(TTS.isLanguageAvailable(Locale.US)==TextToSpeech.LANG_AVAILABLE)
                        TTS.setLanguage(Locale.US);
                    TTS.setPitch(1.3f);
                    TTS.setSpeechRate(0.7f);
                    // start speak
                    speakWords(data);

                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            startActivity(new Intent(Testcomplete.this,TestVdetail.class));
                        }
                    },6000L);



                }
                else if (initStatus == TextToSpeech.ERROR) {
                    Toast.makeText(getApplicationContext(), "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
                }
            }


        });
    }
    private void speakWords(String speech) {
        TTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }

}
