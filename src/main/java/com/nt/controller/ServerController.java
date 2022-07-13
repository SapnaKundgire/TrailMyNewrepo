package com.nt.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.ecxception.ServerNotFoundException;

import com.nt.model.ServerModel;


import com.nt.service.ServerService;
@RequestMapping("/server")
@RestController
public class ServerController {
	@Autowired
	  ServerService serverservice;
	
	@GetMapping("/getAllservers")
	public @ResponseBody List<ServerModel> getAllServer(){
		List<ServerModel> serverinfo= serverservice.getServers();
		return serverinfo;

	}
	@GetMapping("/getservers/{id}")
	public @ResponseBody ServerModel getServerById(@PathVariable("id")String id ){
		ServerModel server=serverservice.getServerbyId(id);
		   if(server==null)
			throw new ServerNotFoundException("id:"+id);
		   
		     return server;
				}
	
	
	@PutMapping("/updateOrsave")
	public ResponseEntity<ServerModel> updateData(@RequestBody ServerModel servermodel) {
		    	        ServerModel saveserver = serverservice.saveServers(servermodel);
		    	        return ResponseEntity.ok(saveserver);
		}
	
	@DeleteMapping("/delete/{id}")  
	public void deleteUser(@PathVariable  String id)  
	{  
		ServerModel user= serverservice.deleteServerById( id);  
		
	}
	@GetMapping("/getserver/{name}")
	public @ResponseBody ServerModel getServerByName(@PathVariable("name")String name ){
		ServerModel server=serverservice.getServerbyName(name);
		   if(server==null)
			throw new ServerNotFoundException("name:"+name);
		   
		     return server;
				}
	
	
	}

