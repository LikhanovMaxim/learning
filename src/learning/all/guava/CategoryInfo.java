package learning.all.guava;

//import com.google.common.base.MoreObjects;
//import com.google.common.base.Objects;

public class CategoryInfo implements Comparable<CategoryInfo> {

	/**
	 * The id.
	 */
	public String id;

	/**
	 * The parent id.
	 */
	public String parentId;

	/**
	 * The name.
	 */
	public String name;

	/**
	 * Instantiates a new category info.
	 *
	 * @param directory the directory
	 * @param sapClass  the sap class
	 * @param pName     the name
	 */
	public CategoryInfo(String directory, String sapClass, String pName) {
		id = sapClass;
		parentId = directory;
		name = pName;

	}

	/**
	 * @see Comparable#compareTo(Object)
	 */
	@Override
	public int compareTo(CategoryInfo rhs) {
		if (parentId == null && rhs.parentId == null) {
			return id.compareTo(rhs.id);
		}
		Integer result = compareIfOneParentIdIsNull(rhs);
		if (result == null) {
			result = parentId.compareTo(rhs.parentId);
			result = result == 0 ? id.compareTo(rhs.id) : result;
		}
		return result;
	}

	private Integer compareIfOneParentIdIsNull(CategoryInfo rhs) {
		if (parentId == null) {
			int val = id.compareTo(rhs.parentId);
			return val == 0 ? -1 : val;
		}
		if (rhs.parentId == null) {
			int val = parentId.compareTo(rhs.id);
			return val == 0 ? 1 : val;
		}
		return null;
	}

	//	@Override
	//	public boolean equals(Object obj) {
	//		if (obj == null || getClass() != obj.getClass()) {
	//			return false;
	//		}
	//		CategoryInfo other = (CategoryInfo) obj;
	//		return Objects.equal(id, other.id) &&
	//				Objects.equal(parentId, other.parentId) &&
	//				Objects.equal(name, other.name);
	//	}
	//
	//	@Override
	//	public String toString() {
	//		return MoreObjects.toStringHelper(this)
	//				.add("id", id)
	//				.add("parentId", parentId)
	//				.add("name", name)
	//				.toString();
	//	}
}
