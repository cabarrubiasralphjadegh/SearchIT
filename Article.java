
package org.example;

import java.util.List;

public class Article {

    private int id;
    private String title;
    private String category;
    private String description;
    private String definition;
    private String history;
    private String coreConcepts;
    private String howItWorks;
    private String types;
    private String examples;
    private String applications;
    private String advantages;
    private String limitations;
    private String relatedTopics;
    private List<String> references;

    public Article(int id, String title, String category,
                   String description, String definition,
                   String history, String coreConcepts,
                   String howItWorks, String types,
                   String examples, String applications,
                   String advantages, String limitations,
                   String relatedTopics, List<String> references) {

        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.definition = definition;
        this.history = history;
        this.coreConcepts = coreConcepts;
        this.howItWorks = howItWorks;
        this.types = types;
        this.examples = examples;
        this.applications = applications;
        this.advantages = advantages;
        this.limitations = limitations;
        this.relatedTopics = relatedTopics;
        this.references = references;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getDefinition() { return definition; }
    public String getHistory() { return history; }
    public String getCoreConcepts() { return coreConcepts; }
    public String getHowItWorks() { return howItWorks; }
    public String getTypes() { return types; }
    public String getExamples() { return examples; }
    public String getApplications() { return applications; }
    public String getAdvantages() { return advantages; }
    public String getLimitations() { return limitations; }
    public String getRelatedTopics() { return relatedTopics; }
    public List<String> getReferences() { return references; }
}
