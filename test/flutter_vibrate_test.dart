import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_vibrate/flutter_vibrate.dart';

void main() {
  const MethodChannel channel = MethodChannel('flutter_vibrate');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      if (methodCall.method == 'canVibrate') {
        return true;
      } else {
        throw Exception('Test not implemented');
      }
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('canVibrate', () async {
    expect(await Vibrate.canVibrate, true);
  });
}
