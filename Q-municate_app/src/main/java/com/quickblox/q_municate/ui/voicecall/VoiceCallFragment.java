package com.quickblox.q_municate.ui.voicecall;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.quickblox.q_municate.R;
import com.quickblox.q_municate.ui.mediacall.OutgoingCallFragment;
import com.quickblox.q_municate.ui.views.RoundedImageView;
import com.quickblox.q_municate.utils.Consts;
import com.quickblox.q_municate_core.db.managers.UsersDatabaseManager;
import com.quickblox.q_municate_core.models.User;

public class VoiceCallFragment extends OutgoingCallFragment {

    @Override
    protected void initUI(View rootView) {
        super.initUI(rootView);

        User friendFromDB = UsersDatabaseManager.getUserById(getActivity().getBaseContext(), opponent.getUserId());

        if (/*opponent*/ friendFromDB != null) {
            ((TextView) rootView.findViewById(R.id.name_textview)).setText(/*opponent*/ friendFromDB.getFullName());
            RoundedImageView avatarView = (RoundedImageView) rootView.findViewById(R.id.avatar_imageview);
            avatarView.setOval(true);
            if (!TextUtils.isEmpty(/*opponent*/ friendFromDB.getAvatarUrl())) {
                ImageLoader.getInstance().displayImage(/*opponent*/ friendFromDB.getAvatarUrl(),
                        avatarView, Consts.UIL_USER_AVATAR_DISPLAY_OPTIONS);
            }
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_voice_call;
    }

}
