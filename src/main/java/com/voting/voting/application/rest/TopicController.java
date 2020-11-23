package com.voting.voting.application.rest;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.voting.voting.application.requests.TopicRequest;
import com.voting.voting.application.requests.VoteRequest;
import com.voting.voting.domain.entities.Topic;
import com.voting.voting.domain.entities.Vote;
import com.voting.voting.domain.services.TopicService;
import com.voting.voting.domain.services.VoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/topic")
public class TopicController {

    @Autowired
    protected TopicService topicService;

    @Autowired
    protected VoteService voteService;

    @PostMapping(value = "")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public Topic createTopic(@Valid @RequestBody TopicRequest topicRequest) {
        return topicService.create(topicRequest);
    }

    @GetMapping(value = "")
    @ResponseBody
    public List<Topic> getAllTopics() {
        return topicService.list();
    }

    @GetMapping(value = "/{uuid}")
    @ResponseBody
    public Topic getTopic(@PathVariable("uuid") UUID uuid) {
        return topicService.show(uuid);
    }

    @PostMapping(value = "/{uuid}/votes")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public Vote createVote(@PathVariable("uuid") UUID uuid, @Valid @RequestBody VoteRequest voteRequest) {
        Topic topic = topicService.show(uuid);
        return voteService.create(topic, voteRequest);
    }

    @GetMapping(value = "/{uuid}/votes")
    @ResponseBody
    public List<Vote> getVotes(@PathVariable("uuid") UUID uuid) {
        return voteService.list(uuid);
    }
}
