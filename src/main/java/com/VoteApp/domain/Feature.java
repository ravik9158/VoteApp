package com.VoteApp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


// POST -> freshvotes.com/products/{productId}/features   (create a feature request)
// GET ->  freshvotes.com/products/{productId}/features/{featureId}   (get a feature)
@Entity
public class Feature
{
  private Long id;
  private String title;
  private String description;
  private String status;
  private Product product;
  private User user;
  private List<Comment> comments = new ArrayList<>();
  
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  public Long getId()
  {
    return id;
  }
  public void setId(Long id)
  {
    this.id = id;
  }
  public String getTitle()
  {
    return title;
  }
  public void setTitle(String title)
  {
    this.title = title;
  }
  public String getDescription()
  {
    return description;
  }
  public void setDescription(String description)
  {
    this.description = description;
  }
  public String getStatus()
  {
    return status;
  }
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  @ManyToOne
  public Product getProduct() {
    return product;
  }
  public void setProduct(Product product) {
    this.product = product;
  }
  @ManyToOne
  public User getUser() {
    return user;
  }
  public void setUser(User user) {
    this.user = user;
  }
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="feature")
  public List<Comment> getComments() {
    return comments;
  }
  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }
}