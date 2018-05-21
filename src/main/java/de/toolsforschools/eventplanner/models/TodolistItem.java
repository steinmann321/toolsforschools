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
	private @NonNull Long amountNeeded;
	private @NonNull Long amountReady;
}
