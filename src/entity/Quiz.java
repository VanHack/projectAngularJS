package entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.ws.rs.Produces;
public class Quiz implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String description;

	private String optionA;

	private String optionB;

	private String optionC;

	private String correctOption;

	private Calendar createdAt;

	private Calendar dataToShow;

	private Boolean available;

	public Quiz() {
	}

	public Quiz(Integer id, String description, String optionA, String optionB, String optionC, String correctOption,
			Calendar createdAt, Calendar dataToShow) {
		super();
		this.id = id;
		this.description = description;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.correctOption = correctOption;
		this.createdAt = createdAt;
		this.dataToShow = dataToShow;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	public Calendar getDataToShow() {
		return dataToShow;
	}

	public void setDataToShow(Calendar dataToShow) {
		this.dataToShow = dataToShow;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correctOption == null) ? 0 : correctOption.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((dataToShow == null) ? 0 : dataToShow.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((optionA == null) ? 0 : optionA.hashCode());
		result = prime * result + ((optionB == null) ? 0 : optionB.hashCode());
		result = prime * result + ((optionC == null) ? 0 : optionC.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quiz other = (Quiz) obj;
		if (correctOption == null) {
			if (other.correctOption != null)
				return false;
		} else if (!correctOption.equals(other.correctOption))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (dataToShow == null) {
			if (other.dataToShow != null)
				return false;
		} else if (!dataToShow.equals(other.dataToShow))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (optionA == null) {
			if (other.optionA != null)
				return false;
		} else if (!optionA.equals(other.optionA))
			return false;
		if (optionB == null) {
			if (other.optionB != null)
				return false;
		} else if (!optionB.equals(other.optionB))
			return false;
		if (optionC == null) {
			if (other.optionC != null)
				return false;
		} else if (!optionC.equals(other.optionC))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", description=" + description + ", optionA=" + optionA + ", optionB=" + optionB
				+ ", optionC=" + optionC + ", correctOption=" + correctOption + ", createdAt=" + createdAt
				+ ", dataToShow=" + dataToShow + ", available=" + available + "]";
	}

}
