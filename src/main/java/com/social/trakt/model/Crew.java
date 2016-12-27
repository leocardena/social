
package com.social.trakt.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "production",
    "costume & make-up",
    "writing",
    "art",
    "camera",
    "sound",
    "directing",
    "visual effects",
    "crew",
    "editing"
})
public class Crew {

    @JsonProperty("production")
    private List<Job> production;
//    @JsonProperty("costume & make-up")
//    private List<Job> costumeMakeUp;
    @JsonProperty("writing")
    private List<Job> writing;
//    @JsonProperty("art")
//    private List<Job> art;
//    @JsonProperty("camera")
//    private List<Job> camera;
//    @JsonProperty("sound")
//    private List<Job> sound;
    @JsonProperty("directing")
    private List<Job> directing;
//    @JsonProperty("visual effects")
//    private List<Job> visualEffects;
//    @JsonProperty("crew")
//    private List<Job> crew;
//    @JsonProperty("editing")
//    private List<Job> editing;

    @JsonProperty("production")
    public List<Job> getProduction() {
        return production;
    }

    @JsonProperty("production")
    public void setProduction(List<Job> production) {
        this.production = production;
    }

//    @JsonProperty("costume & make-up")
//    public List<Job> getCostumeMakeUp() {
//        return costumeMakeUp;
//    }
//
//    @JsonProperty("costume & make-up")
//    public void setCostumeMakeUp(List<Job> costumeMakeUp) {
//        this.costumeMakeUp = costumeMakeUp;
//    }

    @JsonProperty("writing")
    public List<Job> getWriting() {
        return writing;
    }

    @JsonProperty("writing")
    public void setWriting(List<Job> writing) {
        this.writing = writing;
    }

//    @JsonProperty("art")
//    public List<Job> getArt() {
//        return art;
//    }
//
//    @JsonProperty("art")
//    public void setArt(List<Job> art) {
//        this.art = art;
//    }
//
//    @JsonProperty("camera")
//    public List<Job> getCamera() {
//        return camera;
//    }
//
//    @JsonProperty("camera")
//    public void setCamera(List<Job> camera) {
//        this.camera = camera;
//    }
//
//    @JsonProperty("sound")
//    public List<Job> getSound() {
//        return sound;
//    }
//
//    @JsonProperty("sound")
//    public void setSound(List<Job> sound) {
//        this.sound = sound;
//    }

    @JsonProperty("directing")
    public List<Job> getDirecting() {
        return directing;
    }

    @JsonProperty("directing")
    public void setDirecting(List<Job> directing) {
        this.directing = directing;
    }

//    @JsonProperty("visual effects")
//    public List<Job> getVisualEffects() {
//        return visualEffects;
//    }
//
//    @JsonProperty("visual effects")
//    public void setVisualEffects(List<Job> visualEffects) {
//        this.visualEffects = visualEffects;
//    }
//    
//    @JsonProperty("crew")
//    public List<Job> getCrew() {
//    return crew;
//    }
//
//    @JsonProperty("crew")
//    public void setCrew(List<Job> crew) {
//    this.crew = crew;
//    }
//    
//    @JsonProperty("editing")
//    public List<Job> getEditing() {
//    return editing;
//    }
//
//    @JsonProperty("editing")
//    public void setEditing(List<Job> editing) {
//    this.editing = editing;
//    }

}
