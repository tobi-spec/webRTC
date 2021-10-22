import React from 'react';

const conn = new WebSocket("ws://localhost:8080/socket");

const send = (message:string)=> {
  conn.send(JSON.stringify(message))
};

const peerConnection = new RTCPeerConnection()

const dataChannel = peerConnection.createDataChannel("dataChannel", );

dataChannel.onerror = function(error){
  console.log("Error", error)
}

dataChannel.onclose = function () {
  console.log("Data channel is closed")
}

peerConnection.createOffer(function (offer){
  send({
    event : "offer",
    data : offer
  });
  peerConnection.setLocalDescription(offer);
})


function App() {
  return (<section> Hello webRTC </section>);
}

export default App;
