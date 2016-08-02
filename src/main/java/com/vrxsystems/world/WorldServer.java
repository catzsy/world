package com.vrxsystems.world;

import org.zeromq.ZMQ;

public class WorldServer {
	public static void main(String[] args) throws Exception {
		ZMQ.Context context = ZMQ.context(1);

		// Socket to talk to clients
		ZMQ.Socket socket = context.socket(ZMQ.REP);

		socket.bind("tcp://*:5556");

		while (!Thread.currentThread().isInterrupted()) {

			byte[] reply = socket.recv(0);
			System.out.println("World Server - Received " + ": [" + new String(reply, ZMQ.CHARSET) + "]");

			// Create a "Hello" message.
			String response = "world";
			// Send the message
			socket.send(response.getBytes(ZMQ.CHARSET), 0);

			Thread.sleep(1000); // Do some 'work'
		}

		socket.close();
		context.term();
	}

}
