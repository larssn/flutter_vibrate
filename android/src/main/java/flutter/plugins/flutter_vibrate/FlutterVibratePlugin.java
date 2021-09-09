package flutter.plugins.flutter_vibrate;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.HapticFeedbackConstants;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** FlutterVibratePlugin */
public class FlutterVibratePlugin implements FlutterPlugin, MethodCallHandler {
  private MethodChannel channel;
  private Vibrator _vibrator;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flutter_vibrate");
    channel.setMethodCallHandler(this);
    _vibrator = (Vibrator) flutterPluginBinding.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    switch (call.method) {
      case "vibrate":
        if (_vibrator.hasVibrator()) {
          int duration = call.argument("duration");
          if (Build.VERSION.SDK_INT >= 26) {
            _vibrator.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
          } else {
            _vibrator.vibrate(duration);
          }
        }

        result.success(null);
        break;
      case "canVibrate":
        result.success(_vibrator.hasVibrator());
        break;
      case "impact":
        if (_vibrator.hasVibrator()) {
          if (Build.VERSION.SDK_INT >= 26) {
            _vibrator.vibrate(VibrationEffect.createOneShot(HapticFeedbackConstants.VIRTUAL_KEY, VibrationEffect.DEFAULT_AMPLITUDE));
          } else {
            _vibrator.vibrate(HapticFeedbackConstants.VIRTUAL_KEY);
          }
        }
        result.success(null);
        break;
      case "selection":
        if (_vibrator.hasVibrator()) {
          if (Build.VERSION.SDK_INT >= 26) {
            _vibrator.vibrate(VibrationEffect.createOneShot(HapticFeedbackConstants.KEYBOARD_TAP, VibrationEffect.DEFAULT_AMPLITUDE));
          } else {
            _vibrator.vibrate(HapticFeedbackConstants.KEYBOARD_TAP);
          }
        }
        result.success(null);
        break;
      case "success":
        if (_vibrator.hasVibrator()) {
          int duration = 50;
          if (Build.VERSION.SDK_INT >= 26) {
            _vibrator.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
          } else {
            _vibrator.vibrate(duration);
          }
        }
        result.success(null);
        break;
      case "warning":
        if (_vibrator.hasVibrator()) {
          int duration = 250;
          if (Build.VERSION.SDK_INT >= 26) {
            _vibrator.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
          } else {
            _vibrator.vibrate(duration);
          }
        }
        result.success(null);
        break;
      case "error":
        if (_vibrator.hasVibrator()) {
          int duration = 500;
          if (Build.VERSION.SDK_INT >= 26) {
            _vibrator.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
          } else {
            _vibrator.vibrate(duration);
          }
        }
        result.success(null);
        break;
      case "heavy":
        if (_vibrator.hasVibrator()) {
          int duration = 100;
          if (Build.VERSION.SDK_INT >= 26) {
            _vibrator.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
          } else {
            _vibrator.vibrate(duration);
          }
        }
        result.success(null);
        break;
      case "medium":
        if (_vibrator.hasVibrator()) {
          int duration = 40;
          if (Build.VERSION.SDK_INT >= 26) {
            _vibrator.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
          } else {
            _vibrator.vibrate(duration);
          }
        }
        result.success(null);
        break;
      case "light":
        if (_vibrator.hasVibrator()) {
          int duration = 10;
          if (Build.VERSION.SDK_INT >= 26) {
            _vibrator.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
          } else {
            _vibrator.vibrate(duration);
          }
        }
        result.success(null);
        break;
      default:
        result.notImplemented();
        break;
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
