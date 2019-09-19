package org.vishal.projects.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.vishal.projects.messanger.model.Profile;
import org.vishal.projects.messanger.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

		ProfileService profileService = new ProfileService();
		
		@GET
		public List<Profile> getAllProfiles() {
			return profileService.getAllProfiles();
		}
		
		@GET
		@Path("/{user}")
		public Profile getProfile(@PathParam("user") String user) {
			return profileService.getProfile(user);
		}
		
		@POST
		public Profile addProfile(Profile profile) {
			return profileService.addProfile(profile);
		}
		
		@PUT
		@Path("/{user}")
		public Profile updateProfile(@PathParam("user") String user, Profile profile) {
			Client client = ClientBuilder.newClient();
			Profile currentProfile = client.target("http://localhost:8080/messanger/webapi/profiles/{user}")
					                       .resolveTemplate("user", user)
					                       .request(MediaType.APPLICATION_JSON)
					                       .get(Profile.class);
			profile.setId(currentProfile.getId());
			profile.setProfileName(user);
			return profileService.updateProfile(profile);
		}
		
		@DELETE
		@Path("/{user}")
		public void deleteProfile(@PathParam("user") String user) {
			profileService.removeProfile(user);
		}
}
