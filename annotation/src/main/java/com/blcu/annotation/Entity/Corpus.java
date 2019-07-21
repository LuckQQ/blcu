package com.blcu.annotation.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/**
 * 语料实体类
 * @author Administrator
 *
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "corpus")
public class Corpus {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@CreatedDate
	@Column(name = "create_time")
	private Long createTime;
	
	@LastModifiedDate
	@Column(name = "update_time")
	private Long updateTime;
	
	@Column(name = "skip_reason")
	private String skipReason;
	
	@Column(name = "original_sent")
	private String originalSent;
	
	@Column(name = "machine_sent")
	private String machineSent;
	
	@Column(name = "res_sent")
	private String resSent;
	
	@Column(name = "status_id")
	private String statusId;
}
