#import "FlutterVibratePlugin.h"
#if __has_include(<flutter_vibrate/flutter_vibrate-Swift.h>)
#import <flutter_vibrate/flutter_vibrate-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "flutter_vibrate-Swift.h"
#endif

@implementation FlutterVibratePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterVibratePlugin registerWithRegistrar:registrar];
}
@end
