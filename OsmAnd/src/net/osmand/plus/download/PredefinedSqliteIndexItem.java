package net.osmand.plus.download;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.osmand.map.OsmandRegions;
import net.osmand.map.WorldRegion;
import net.osmand.plus.OsmandApplication;

/**
 * Predefined online map (.sqlitedb) that is downloaded from a fixed URL
 * and placed to the "tiles" folder (see {@link DownloadActivityType#SQLITE_FILE}).
 */
public class PredefinedSqliteIndexItem extends IndexItem {

	private final String visibleName;
	private final String downloadUrl;

	public PredefinedSqliteIndexItem(@NonNull String fileName,
	                                 @NonNull String visibleName,
	                                 @NonNull String downloadUrl,
	                                 long timestamp,
	                                 long sizeInBytes) {
		super(fileName, null, timestamp, String.valueOf(sizeInBytes / (double) (1 << 20)),
				sizeInBytes, sizeInBytes, DownloadActivityType.SQLITE_FILE, false, null);
		this.visibleName = visibleName;
		this.downloadUrl = downloadUrl;
	}

	@Override
	public DownloadEntry createDownloadEntry(OsmandApplication ctx) {
		DownloadEntry entry = super.createDownloadEntry(ctx);
		if (entry != null) {
			entry.urlToDownload = downloadUrl;
			entry.zipStream = false;
		}
		return entry;
	}

	@Override
	public String getVisibleName(@NonNull Context ctx, @NonNull OsmandRegions regions,
	                             boolean includingParent, @Nullable WorldRegion baseParentRegion,
	                             boolean useShortName) {
		return visibleName;
	}
}
