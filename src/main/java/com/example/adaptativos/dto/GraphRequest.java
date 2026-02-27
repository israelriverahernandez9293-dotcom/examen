package com.example.adaptativos.dto;

import jakarta.validation.constraints.NotBlank;

public class GraphRequest {
    @NotBlank
    private String nodes = "A,B,C,D,E";
    @NotBlank
    private String edges = "A-B, A-C, B-D, C-E";
    @NotBlank
    private String startNode = "A";

    public String getNodes() { return nodes; }
    public void setNodes(String nodes) { this.nodes = nodes; }
    public String getEdges() { return edges; }
    public void setEdges(String edges) { this.edges = edges; }
    public String getStartNode() { return startNode; }
    public void setStartNode(String startNode) { this.startNode = startNode; }
}
