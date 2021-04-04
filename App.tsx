import React, {useState, useEffect} from 'react';
import {StyleSheet, Text, View} from 'react-native';

// import custom module
import ABC from './CustomModule';

const App = () => {
  const [deviceId, setdeviceId] = useState('');
  useEffect(() => {
    const fetchDeviceId = async () => {
      const id = await ABC.getDeviceId();
      setdeviceId(id);
    };

    fetchDeviceId();
  }, []);

  console.log(ABC.show());
  return (
    <View style={styles.container}>
     
     <Text>{deviceId}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white',
    justifyContent: 'center',
    alignItems: 'center',
  },
 
});

export default App;
