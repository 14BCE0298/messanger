package org.vishal.projects.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.vishal.projects.messanger.database.Database;
import org.vishal.projects.messanger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = Database.getProfiles();

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String user) {
		return profiles.get(user);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		} else {
			profiles.put(profile.getProfileName(), profile);
		}
		return profile;
	}

	public void removeProfile(String user) {
		profiles.remove(user);
	}

}
