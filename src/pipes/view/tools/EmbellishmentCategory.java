package pipes.view.tools;

import java.util.LinkedList;
import java.util.List;

import pipes.model.embellishment.EmbellishmentFamily;

public class EmbellishmentCategory {
	
	public static final List<EmbellishmentCategory> CATEGORIES;
	public static final EmbellishmentCategory MISCELLANEOUS;
	
	static {
		CATEGORIES = new LinkedList<>();
	
		CATEGORIES.add(new EmbellishmentCategory("Grace Notes",
				EmbellishmentFamily.A_GRACE,
				EmbellishmentFamily.G_GRACE,
				EmbellishmentFamily.D_GRACE,
				EmbellishmentFamily.E_GRACE,
				EmbellishmentFamily.STRIKE));

		CATEGORIES.add(new EmbellishmentCategory("Grips",
				EmbellishmentFamily.GRIP,
				EmbellishmentFamily.TAOR,
				EmbellishmentFamily.CRUN));
		
		CATEGORIES.add(new EmbellishmentCategory("Birls",
				EmbellishmentFamily.BIRL));
		
		MISCELLANEOUS = new EmbellishmentCategory("Miscellaneous", 
				EmbellishmentFamily.THROW,
				EmbellishmentFamily.DOUBLING);
	}
	
	public String toString() {
		return name;
	}
	
	public Iterable<EmbellishmentFamily> getEmbellishments() {
		return embellishments;
	}
	
	public EmbellishmentCategory(String name, EmbellishmentFamily... embellishements) {
		this.name = name;
		this.embellishments = new LinkedList<>();
		for (EmbellishmentFamily fam : embellishements)
			this.embellishments.add(fam);
	}
	
	private String name;
	private List<EmbellishmentFamily> embellishments;
}
