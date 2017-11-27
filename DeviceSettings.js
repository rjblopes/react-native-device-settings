
import { NativeModules, Linking, Platform } from 'react-native';
const { RNOpenSettings } = NativeModules;

function open(){
  try{
    (Platform.OS === 'ios') ?
      Linking.openURL('App-prefs:') :
      RNOpenSettings.generalSettings();
  }catch(err){
    console.error(err);
  }
}

function app(){
  try{
    (Platform.OS === 'ios') ?
      Linking.openURL('app-settings:') :
      RNOpenSettings.appSettings();
  }catch(err){
    console.error(err);
  }
}

function wifi(){
  try{
    (Platform.OS === 'ios') ?
      Linking.openURL('App-prefs:root=WIFI') :
      RNOpenSettings.wifiSettings();
  }catch(err){
    console.error(err);
  }
}

function bluetooth(){
  try{
    (Platform.OS === 'ios') ?
      Linking.openURL('App-prefs:root=Bluetooth') :
      RNOpenSettings.bluetoothSettings();
  }catch(err){
    console.error(err);
  }
}

module.exports = { open , app, wifi, bluetooth };
