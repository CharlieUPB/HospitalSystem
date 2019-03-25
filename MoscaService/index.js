
var mosca = require("mosca");
var server = new mosca.Server({
  http: {
    port: 3000,
    bundle: true,
    static: './'
  }
});

server.on('clientConnected', function(client) {
    console.log('client connected', client.id);
});

server.on('clientDisconnected', function(client) {
    console.log('Client Disconnected:', client.id);
});
 
server.on('ready', () => {
    console.log('Mosca server is up and running');
});
