<<<<<<< HEAD
package com.webapp.entry;

import java.util.Map;

public class KkTopic {

	private int id;
	private int labelId;
	private String title;
	private String description;

	private int comicsCount;
	private String verticalImageUrl;
	private int createdAt;
	private int updatedAt;

	private String likes;

	private int likesCount;
	private int order;

	private String authName;

	//
	public KkTopic() {
	}
	//

	//
	public int getId() {
		return id;
	}

	/**
	 */
	public KkTopic(int id, int labelId, String title, String description, int comicsCount, String verticalImageUrl,
			int createdAt, int updatedAt, String likes, int likesCount, int order, String authName) {
		super();
		this.id = id;
		this.labelId = labelId;
		this.title = title;
		this.description = description;
		this.comicsCount = comicsCount;
		this.verticalImageUrl = verticalImageUrl;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.likes = likes;
		this.likesCount = likesCount;
		this.order = order;
		this.authName = authName;
	}

	/**
	 */
	public KkTopic(Map data) {
		Map user = (Map) data.get("user");
		this.id = ((Integer) data.get("id")).intValue();
		this.labelId = ((Integer) data.get("label_id")).intValue();
		this.title = (String) data.get("title");
		this.description = (String) data.get("description");
		this.comicsCount = ((Integer) data.get("comics_count")).intValue();
		this.verticalImageUrl = (String) data.get("vertical_image_url");
		this.createdAt = ((Integer) data.get("created_at")).intValue();
		this.updatedAt = ((Integer) data.get("updated_at")).intValue();
		this.likes = (String) data.get("likes");
		this.likesCount = 0;
		this.order = ((Integer) data.get("order")).intValue();
		//
		this.authName = (String) user.get("nickname");
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLabelId() {
		return labelId;
	}

	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getComicsCount() {
		return comicsCount;
	}

	public void setComicsCount(int comicsCount) {
		this.comicsCount = comicsCount;
	}

	public String getVerticalImageUrl() {
		return verticalImageUrl;
	}

	public void setVerticalImageUrl(String verticalImageUrl) {
		this.verticalImageUrl = verticalImageUrl;
	}

	public int getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}

	public int getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(int updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public int getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

}
=======
package com.webapp.entry;

import java.util.Map;

public class KkTopic {

	private int id;
	private int labelId;
	private String title;
	private String description;

	private int comicsCount;
	private String verticalImageUrl;
	private int createdAt;
	private int updatedAt;

	private String likes;

	private int likesCount;
	private int order;

	private String authName;

	//
	public KkTopic() {
	}
	//

	//
	public int getId() {
		return id;
	}

	/**
	 */
	public KkTopic(int id, int labelId, String title, String description, int comicsCount, String verticalImageUrl,
			int createdAt, int updatedAt, String likes, int likesCount, int order, String authName) {
		super();
		this.id = id;
		this.labelId = labelId;
		this.title = title;
		this.description = description;
		this.comicsCount = comicsCount;
		this.verticalImageUrl = verticalImageUrl;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.likes = likes;
		this.likesCount = likesCount;
		this.order = order;
		this.authName = authName;
	}

	/**
	 */
	public KkTopic(Map data) {
		Map user = (Map) data.get("user");
		this.id = ((Integer) data.get("id")).intValue();
		this.labelId = ((Integer) data.get("label_id")).intValue();
		this.title = (String) data.get("title");
		this.description = (String) data.get("description");
		this.comicsCount = ((Integer) data.get("comics_count")).intValue();
		this.verticalImageUrl = (String) data.get("vertical_image_url");
		this.createdAt = ((Integer) data.get("created_at")).intValue();
		this.updatedAt = ((Integer) data.get("updated_at")).intValue();
		this.likes = (String) data.get("likes");
		this.likesCount = 0;
		this.order = ((Integer) data.get("order")).intValue();
		//
		this.authName = (String) user.get("nickname");
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLabelId() {
		return labelId;
	}

	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getComicsCount() {
		return comicsCount;
	}

	public void setComicsCount(int comicsCount) {
		this.comicsCount = comicsCount;
	}

	public String getVerticalImageUrl() {
		return verticalImageUrl;
	}

	public void setVerticalImageUrl(String verticalImageUrl) {
		this.verticalImageUrl = verticalImageUrl;
	}

	public int getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}

	public int getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(int updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public int getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

}
>>>>>>> branch 'master' of https://github.com/gamedos/first-spring-kkdemo.git
