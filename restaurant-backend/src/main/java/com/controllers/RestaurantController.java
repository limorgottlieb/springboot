package com.controllers;

import com.dtos.Restaurant;
import com.services.RestaurantService;
import org.eclipse.egit.github.core.DownloadResource;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.DownloadService;
import org.eclipse.egit.github.core.service.PullRequestService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by gotli01 on 4/3/2017.
 */
@RestController
@RequestMapping("restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.POST, path = "/restaurant")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) throws IOException {
        GitHubClient client = new GitHubClient();
        client.setCredentials("user", "passw0rd");
        PullRequestService service = new PullRequestService();

        RepositoryService repositoryService = new RepositoryService();
        DownloadService downloadService = new DownloadService(client);

        return restaurantService.saveRestaurant(restaurant);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/clone")
    public GHRepository cloneRepository() throws IOException {
        PullRequestService service = new PullRequestService();
        service.createPullRequest()


    }

}
