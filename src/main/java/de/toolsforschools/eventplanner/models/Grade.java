package de.toolsforschools.eventplanner.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Grade {
	@Id
	@GeneratedValue
	private Long id;
	private @NonNull String name;
	private @NonNull String teacherName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_id")
	private @NonNull School school;
}

