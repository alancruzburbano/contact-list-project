package com.kuenag.app.contacts.entity;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;

@Entity(name="CONTACT")
@Table(name = "CHARACTER_INFO")
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    @NonNull
    @Column(name = "CONTACT_NAME")
    private String name;
    @Getter
    @Setter
    @Column(name = "AVATAR_URL")
    private String urlAvatar;
}
