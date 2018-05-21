package de.toolsforschools.eventplanner.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TodolistItem {
	@Id
	@GeneratedValue
	private Long id;
	private @NonNull String name;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "todolist_id")
	private @NonNull Todolist todolist;
}
