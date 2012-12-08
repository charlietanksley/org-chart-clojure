(ns github-organizations.users
  (:use [github-organizations.github]))

(defn information-on-a-user
  [single-user-hash]
  (let [{login :login
         url :url
         avatar_url :avatar_url}
        single-user-hash]
    {:login login
     :url url
     :avatar_url avatar_url}))

(defn information-on-an-organization
  [single-organization-hash]
  (let [{login :login
         url :url
         avatar_url :avatar_url}
        single-organization-hash]
    {:login login
     :url url
     :avatar_url avatar_url}))

(defn organizations-for-all-members
  "Get a hash of all the organizations for all the members."
  [member-hash]
  (let [users (map :login member-hash)]
    (zipmap (map keyword users) (map organizations-by-member users))))

(defn related-organizations
  "A list of all the related organizations related to the specified
  organization."
  [member-hash]
  (let [results (organizations-for-all-members member-hash)]
    results))

(defn org-info
  [hash-for-one-person]
  (map (fn [hash] (select-keys hash [:login :avatar_url]))
       hash-for-one-person))

(def sample-members-in-organization
  [{:following_url "https://api.github.com/users/ryanwood/following", :gists_url "https://api.github.com/users/ryanwood/gists{/gist_id}", :starred_url "https://api.github.com/users/ryanwood/starred{/owner}{/repo}", :followers_url "https://api.github.com/users/ryanwood/followers", :gravatar_id "e37ca8b3eee534fa6781f7ba13743afb", :avatar_url "https://secure.gravatar.com/avatar/e37ca8b3eee534fa6781f7ba13743afb?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png", :received_events_url "https://api.github.com/users/ryanwood/received_events", :login "ryanwood", :url "https://api.github.com/users/ryanwood", :organizations_url "https://api.github.com/users/ryanwood/orgs", :events_url "https://api.github.com/users/ryanwood/events{/privacy}", :repos_url "https://api.github.com/users/ryanwood/repos", :id 8504, :subscriptions_url "https://api.github.com/users/ryanwood/subscriptions"} {:following_url "https://api.github.com/users/pnc/following", :gists_url "https://api.github.com/users/pnc/gists{/gist_id}", :starred_url "https://api.github.com/users/pnc/starred{/owner}{/repo}", :followers_url "https://api.github.com/users/pnc/followers", :gravatar_id "106e991aff47a77919601a41770ea734", :avatar_url "https://secure.gravatar.com/avatar/106e991aff47a77919601a41770ea734?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png", :received_events_url "https://api.github.com/users/pnc/received_events", :login "pnc", :url "https://api.github.com/users/pnc", :organizations_url "https://api.github.com/users/pnc/orgs", :events_url "https://api.github.com/users/pnc/events{/privacy}", :repos_url "https://api.github.com/users/pnc/repos", :id 108524, :subscriptions_url "https://api.github.com/users/pnc/subscriptions"} {:following_url "https://api.github.com/users/jcoleman/following", :gists_url "https://api.github.com/users/jcoleman/gists{/gist_id}", :starred_url "https://api.github.com/users/jcoleman/starred{/owner}{/repo}", :followers_url "https://api.github.com/users/jcoleman/followers", :gravatar_id "d8d5058aa91cd439f1f486f93f8eb564", :avatar_url "https://secure.gravatar.com/avatar/d8d5058aa91cd439f1f486f93f8eb564?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png", :received_events_url "https://api.github.com/users/jcoleman/received_events", :login "jcoleman", :url "https://api.github.com/users/jcoleman", :organizations_url "https://api.github.com/users/jcoleman/orgs", :events_url "https://api.github.com/users/jcoleman/events{/privacy}", :repos_url "https://api.github.com/users/jcoleman/repos", :id 125331, :subscriptions_url "https://api.github.com/users/jcoleman/subscriptions"} {:following_url "https://api.github.com/users/charlietanksley/following", :gists_url "https://api.github.com/users/charlietanksley/gists{/gist_id}", :starred_url "https://api.github.com/users/charlietanksley/starred{/owner}{/repo}", :followers_url "https://api.github.com/users/charlietanksley/followers", :gravatar_id "262e2db6c19a4f38980e2c4076c1f5a8", :avatar_url "https://secure.gravatar.com/avatar/262e2db6c19a4f38980e2c4076c1f5a8?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png", :received_events_url "https://api.github.com/users/charlietanksley/received_events", :login "charlietanksley", :url "https://api.github.com/users/charlietanksley", :organizations_url "https://api.github.com/users/charlietanksley/orgs", :events_url "https://api.github.com/users/charlietanksley/events{/privacy}", :repos_url "https://api.github.com/users/charlietanksley/repos", :id 217287, :subscriptions_url "https://api.github.com/users/charlietanksley/subscriptions"} {:following_url "https://api.github.com/users/masondesu/following", :gists_url "https://api.github.com/users/masondesu/gists{/gist_id}", :starred_url "https://api.github.com/users/masondesu/starred{/owner}{/repo}", :followers_url "https://api.github.com/users/masondesu/followers", :gravatar_id "091bc95204caaf52b0d299bd9ac59540", :avatar_url "https://secure.gravatar.com/avatar/091bc95204caaf52b0d299bd9ac59540?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png", :received_events_url "https://api.github.com/users/masondesu/received_events", :login "masondesu", :url "https://api.github.com/users/masondesu", :organizations_url "https://api.github.com/users/masondesu/orgs", :events_url "https://api.github.com/users/masondesu/events{/privacy}", :repos_url "https://api.github.com/users/masondesu/repos", :id 434750, :subscriptions_url "https://api.github.com/users/masondesu/subscriptions"}])

(def sample-organizations-for-member
  [{:login "cowork", :repos_url "https://api.github.com/orgs/cowork/repos", :events_url "https://api.github.com/orgs/cowork/events", :url "https://api.github.com/orgs/cowork", :members_url "https://api.github.com/orgs/cowork/members{/member}", :avatar_url "https://secure.gravatar.com/avatar/843cbde825534f0f568ba5de129e2210?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :public_members_url "https://api.github.com/orgs/cowork/public_members{/member}", :id 484435} {:login "GreenvilleRB", :repos_url "https://api.github.com/orgs/GreenvilleRB/repos", :events_url "https://api.github.com/orgs/GreenvilleRB/events", :url "https://api.github.com/orgs/GreenvilleRB", :members_url "https://api.github.com/orgs/GreenvilleRB/members{/member}", :avatar_url "https://secure.gravatar.com/avatar/87abe637730a92831245afd414ba3dfa?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :public_members_url "https://api.github.com/orgs/GreenvilleRB/public_members{/member}", :id 865552}])

(def sample-organizations-for-all-greenvillerbers
  {:masondesu [{:public_members_url "https://api.github.com/orgs/cowork/public_members{/member}", :events_url "https://api.github.com/orgs/cowork/events", :repos_url "https://api.github.com/orgs/cowork/repos", :avatar_url "https://secure.gravatar.com/avatar/843cbde825534f0f568ba5de129e2210?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :url "https://api.github.com/orgs/cowork", :login "cowork", :members_url "https://api.github.com/orgs/cowork/members{/member}", :id 484435} {:public_members_url "https://api.github.com/orgs/zaarly/public_members{/member}", :events_url "https://api.github.com/orgs/zaarly/events", :repos_url "https://api.github.com/orgs/zaarly/repos", :avatar_url "https://secure.gravatar.com/avatar/47d6f6176bf48173e49706b81d0645b6?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :url "https://api.github.com/orgs/zaarly", :login "zaarly", :members_url "https://api.github.com/orgs/zaarly/members{/member}", :id 640255} {:public_members_url "https://api.github.com/orgs/GreenvilleRB/public_members{/member}", :events_url "https://api.github.com/orgs/GreenvilleRB/events", :repos_url "https://api.github.com/orgs/GreenvilleRB/repos", :avatar_url "https://secure.gravatar.com/avatar/87abe637730a92831245afd414ba3dfa?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :url "https://api.github.com/orgs/GreenvilleRB", :login "GreenvilleRB", :members_url "https://api.github.com/orgs/GreenvilleRB/members{/member}", :id 865552} {:public_members_url "https://api.github.com/orgs/theironyard/public_members{/member}", :events_url "https://api.github.com/orgs/theironyard/events", :repos_url "https://api.github.com/orgs/theironyard/repos", :avatar_url "https://secure.gravatar.com/avatar/aea1eee9935ec1ba02d7a486021c385c?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :url "https://api.github.com/orgs/theironyard", :login "theironyard", :members_url "https://api.github.com/orgs/theironyard/members{/member}", :id 2248433}], :charlietanksley [{:login "highgroove", :members_url "https://api.github.com/orgs/highgroove/members{/member}", :public_members_url "https://api.github.com/orgs/highgroove/public_members{/member}", :url "https://api.github.com/orgs/highgroove", :avatar_url "https://secure.gravatar.com/avatar/5bfa7fe1f71a1e01d3709c41dc33f6b8?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :repos_url "https://api.github.com/orgs/highgroove/repos", :id 8729, :events_url "https://api.github.com/orgs/highgroove/events"} {:login "bignerdranch", :members_url "https://api.github.com/orgs/bignerdranch/members{/member}", :public_members_url "https://api.github.com/orgs/bignerdranch/public_members{/member}", :url "https://api.github.com/orgs/bignerdranch", :avatar_url "https://secure.gravatar.com/avatar/141544a4ebe983a7bf990b9bf03abef3?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :repos_url "https://api.github.com/orgs/bignerdranch/repos", :id 230455, :events_url "https://api.github.com/orgs/bignerdranch/events"} {:login "rubinius", :members_url "https://api.github.com/orgs/rubinius/members{/member}", :public_members_url "https://api.github.com/orgs/rubinius/public_members{/member}", :url "https://api.github.com/orgs/rubinius", :avatar_url "https://secure.gravatar.com/avatar/8a664b7c5ca834af3e7e49d3a6160082?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :repos_url "https://api.github.com/orgs/rubinius/repos", :id 317747, :events_url "https://api.github.com/orgs/rubinius/events"} {:login "GreenvilleRB", :members_url "https://api.github.com/orgs/GreenvilleRB/members{/member}", :public_members_url "https://api.github.com/orgs/GreenvilleRB/public_members{/member}", :url "https://api.github.com/orgs/GreenvilleRB", :avatar_url "https://secure.gravatar.com/avatar/87abe637730a92831245afd414ba3dfa?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :repos_url "https://api.github.com/orgs/GreenvilleRB/repos", :id 865552, :events_url "https://api.github.com/orgs/GreenvilleRB/events"}], :jcoleman [{:avatar_url "https://secure.gravatar.com/avatar/87abe637730a92831245afd414ba3dfa?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :login "GreenvilleRB", :public_members_url "https://api.github.com/orgs/GreenvilleRB/public_members{/member}", :url "https://api.github.com/orgs/GreenvilleRB", :repos_url "https://api.github.com/orgs/GreenvilleRB/repos", :events_url "https://api.github.com/orgs/GreenvilleRB/events", :id 865552, :members_url "https://api.github.com/orgs/GreenvilleRB/members{/member}"} {:avatar_url "https://secure.gravatar.com/avatar/01ed72059f8b3279bab6f8d026cb1a7a?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :login "FortisRiders", :public_members_url "https://api.github.com/orgs/FortisRiders/public_members{/member}", :url "https://api.github.com/orgs/FortisRiders", :repos_url "https://api.github.com/orgs/FortisRiders/repos", :events_url "https://api.github.com/orgs/FortisRiders/events", :id 1433889, :members_url "https://api.github.com/orgs/FortisRiders/members{/member}"}], :pnc [{:login "eleostech", :events_url "https://api.github.com/orgs/eleostech/events", :url "https://api.github.com/orgs/eleostech", :members_url "https://api.github.com/orgs/eleostech/members{/member}", :repos_url "https://api.github.com/orgs/eleostech/repos", :id 846841, :avatar_url "https://secure.gravatar.com/avatar/3671f49745a79b2e3206a4d3904377ac?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :public_members_url "https://api.github.com/orgs/eleostech/public_members{/member}"} {:login "GreenvilleRB", :events_url "https://api.github.com/orgs/GreenvilleRB/events", :url "https://api.github.com/orgs/GreenvilleRB", :members_url "https://api.github.com/orgs/GreenvilleRB/members{/member}", :repos_url "https://api.github.com/orgs/GreenvilleRB/repos", :id 865552, :avatar_url "https://secure.gravatar.com/avatar/87abe637730a92831245afd414ba3dfa?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :public_members_url "https://api.github.com/orgs/GreenvilleRB/public_members{/member}"}], :ryanwood [{:login "cowork", :public_members_url "https://api.github.com/orgs/cowork/public_members{/member}", :repos_url "https://api.github.com/orgs/cowork/repos", :events_url "https://api.github.com/orgs/cowork/events", :url "https://api.github.com/orgs/cowork", :id 484435, :avatar_url "https://secure.gravatar.com/avatar/843cbde825534f0f568ba5de129e2210?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :members_url "https://api.github.com/orgs/cowork/members{/member}"} {:login "GreenvilleRB", :public_members_url "https://api.github.com/orgs/GreenvilleRB/public_members{/member}", :repos_url "https://api.github.com/orgs/GreenvilleRB/repos", :events_url "https://api.github.com/orgs/GreenvilleRB/events", :url "https://api.github.com/orgs/GreenvilleRB", :id 865552, :avatar_url "https://secure.gravatar.com/avatar/87abe637730a92831245afd414ba3dfa?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-org-420.png", :members_url "https://api.github.com/orgs/GreenvilleRB/members{/member}"}]})
